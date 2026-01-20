export type SongCreateDto = {
  artistId: number;
  albumId: number;
  title: string;
  subtitle?: string | null;
  releaseDate?: string | null;
  durationSeconds?: number | null;
  languageCode?: string | null;
  genreIds?: string[] | null;
  instrumentationIds?: string[] | null;
  moodIds?: string[] | null;
};

export type SongUpdateDto = {
  artistId: number;
  albumId: number;
  title: string;
  subtitle?: string | null;
  releaseDate?: string | null;
  durationSeconds?: number | null;
  languageCode?: string | null;
  genreIds?: string[] | null;
  instrumentationIds?: string[] | null;
  moodIds?: string[] | null;
};

export type SongResponseDto = {
  id: number;
  artistId: number;
  albumId: number;
  title: string;
  subtitle?: string | null;
  releaseDate?: string | null;
  durationSeconds?: number | null;
  languageCode?: string | null;
  genres?: string[] | null;
  instrumentations?: string[] | null;
  moods?: string[] | null;
  createdAt: string;
  updatedAt: string;
};

export type SongListItemDto = {
  id: number;
  artistId: number;
  albumId: number;
  title: string;
  subtitle?: string | null;
  releaseDate?: string | null;
  durationSeconds?: number | null;
  languageCode?: string | null;
  genres?: string[] | null;
  instrumentations?: string[] | null;
  moods: string[] | null;
  createdAt: string;
  updatedAt: string;
};
