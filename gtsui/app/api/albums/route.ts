import { AlbumCreateDto, AlbumListItemDto } from "@/dtos/album";
import { SongCreateDto, SongResponseDto } from "@/dtos/song";
import springApi from "@/lib/services/springApi";
import { NextRequest, NextResponse } from "next/server";

export async function GET() {
  try {
    const response = await springApi.get<AlbumListItemDto>("/albums");
    return NextResponse.json(response.data);
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to fetch albums" },
      { status: error.response?.status || 500 },
    );
  }
}

export async function POST(request: NextRequest) {
  try {
    const body: AlbumCreateDto = await request.json();
    const response = await springApi.post("/albums/insert", body);
    return NextResponse.json(response.data, { status: 201 });
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to insert album" },
      { status: error.response?.status || 500 },
    );
  }
}
