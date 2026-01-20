import {
  SongCreateDto,
  SongListItemDto,
  SongResponseDto,
  SongUpdateDto,
} from "@/types/song";
import { apiClient } from "./client";

export const songApi = {
  list: () => apiClient.get<SongListItemDto[]>("/songs"),

  get: (id: number) => apiClient.get<SongResponseDto>(`/songs/${id}`),

  create: (dto: SongCreateDto) =>
    apiClient.post<SongResponseDto>("/songs", dto),

  update: (id: number, dto: SongUpdateDto) =>
    apiClient.put<SongResponseDto>(`/songs/${id}`, dto),

  delete: (id: number) => apiClient.delete(`/songs/${id}`),
};
