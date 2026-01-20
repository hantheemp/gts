import { NextRequest, NextResponse } from "next/server";
import springApi from "@/lib/services/springApi";
import type { SongResponseDto, SongUpdateDto } from "@/types/song";

export async function GET(
  request: NextRequest,
  { params }: { params: { id: string } },
) {
  try {
    const response = await springApi.get<SongResponseDto>(
      `/songs/${params.id}`,
    );
    return NextResponse.json(response.data);
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to fetch song" },
      { status: error.response?.status || 500 },
    );
  }
}
export async function PUT(
  request: NextRequest,
  { params }: { params: { id: string } },
) {
  try {
    const body: SongUpdateDto = await request.json();
    const response = await springApi.put(`/songs/update/${params.id}`, body);
    return NextResponse.json(response.data);
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to update song" },
      { status: error.response?.status || 500 },
    );
  }
}

export async function DELETE(
  request: NextRequest,
  { params }: { params: { id: string } },
) {
  try {
    await springApi.delete(`/songs/delete/${params.id}`);
    return new NextResponse(null, { status: 204 });
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to delete song" },
      { status: error.response?.status || 500 },
    );
  }
}
