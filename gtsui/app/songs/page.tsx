"use client";
import React, { useEffect, useState } from "react";
import { songApi } from "@/lib/api/songs";
import type { SongListItemDto, SongResponseDto } from "@/types/song";
import Link from "next/link";

export default function SongsPage() {
  const [songs, setSongs] = useState<SongListItemDto[] | null>(null);
  const [loading, setLoading] = useState(true);
  const [err, setErr] = useState<string | null>(null);

  useEffect(() => {
    
    async function fetchSongs(){
        try {
            const response = await songApi.list();
            console.log("Fetched songs:", response);
            setSongs(response);
        } catch (error) {
            setErr("Failed to fetch songs");
            console.error("Failed to fetch songs", error);
        }
    }

    fetchSongs().finally(() => setLoading(false));

  }, []);

  if (loading) return <div>Loading...</div>;
  if (err) return <div>Error: {err}</div>;
  if (!songs || songs.length === 0) return <div>No songs</div>;

  return (
    <div>
      <h1>Songs</h1>
      <Link href="/songs/new">Create new</Link>
      <ul>
        {songs.map((s) => (
          <li key={s.id}>
            <Link href={`/songs/${s.id}`}>
              {s.title} — {s.artistId}
            </Link>
          </li>
        ))}
      </ul>
    </div>
  );
}
