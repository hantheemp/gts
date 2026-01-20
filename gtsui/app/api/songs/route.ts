import springApi from "@/lib/services/springApi";
import { SongCreateDto, SongListItemDto } from "@/types/song";
import { NextRequest, NextResponse } from "next/server";

export async function GET() {
  try {
    const response = await springApi.get<SongListItemDto[]>("/songs");

    return NextResponse.json(response.data);
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to fetch songs" },
      { status: error.response?.status || 500 },
    );
  }
}

export async function POST(request: NextRequest) {
  try {
    const body: SongCreateDto = await request.json();
    const response = await springApi.post("/songs/insert", body);
    return NextResponse.json(response.data, { status: 201 });
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to insert song" },
      { status: error.response?.status || 500 },
    );
  }
}
