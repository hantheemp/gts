import { api } from "../axios";
import type {
  SongCreateDto,
  SongUpdateDto,
  SongResponseDto,
  SongListItemDto,
} from "@/types/song";

export const songApi = {
  list: async (): Promise<SongListItemDto[]> => {
    return api.get<SongListItemDto[]>("/songs");
  },
  get: async (id: number): Promise<SongResponseDto> => {
    return api.get<SongResponseDto>(`/songs/${id}`);
  },
  insert: async (dto: SongCreateDto): Promise<SongResponseDto> => {
    return api.post<SongResponseDto>("/insert", dto);
  },
  update: async (id: number, dto: SongUpdateDto): Promise<SongResponseDto> => {
    return api.put<SongResponseDto>(`/songs/update/${id}`, dto);
  },
  delete: async (id: number): Promise<void> => {
    return api.delete<void>(`/songs/delete/${id}`);
  },
};