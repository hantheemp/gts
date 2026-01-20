import { AlbumResponseDto, AlbumUpdateDto } from "@/dtos/album";
import springApi from "@/lib/services/springApi";
import { NextRequest, NextResponse } from "next/server";

export async function GET(
  request: NextRequest,
  { params }: { params: { id: string } },
) {
  try {
    const response = await springApi.get<AlbumResponseDto>(
      `/albums/${params.id}`,
    );
    return NextResponse.json(response.data);
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to fetch album" },
      { status: error.response?.status || 500 },
    );
  }
}

export async function PUT(
  request: NextRequest,
  { params }: { params: { id: string } },
) {
  try {
    const body: AlbumUpdateDto = await request.json();
    const response = await springApi.put(`/albums/update/${params.id}`, body);
    return NextResponse.json(response.data);
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to update album" },
      { status: error.response?.status || 500 },
    );
  }
}

export async function DELETE(
  request: NextRequest,
  { params }: { params: { id: string } },
) {
  try {
    await springApi.delete(`/albums/delete/${params.id}`);
    return new NextResponse(null, { status: 204 });
  } catch (error: any) {
    return NextResponse.json(
      { error: error.message || "Failed to delete album" },
      { status: error.response?.status || 500 },
    );
  }
}
