export type AlbumCreateDto = {
  artistId: number;
  title: string;
  releaseDate: string;
  coverArtUrl?: string | null;
};

export type AlbumUpdateDto = {
  artistId: number;
  title: string;
  releaseDate: string;
  coverArtUrl?: string | null;
};

export type AlbumResponseDto = {
  id: number;
  artistId: number;
  title: string;
  releaseDate: string;
  coverArtUrl?: string | null;
  createdAt: string;
  updatedAt: string;
};
export type AlbumListItemDto = {
  id: number;
  artistId: number;
  title: string;
  releaseDate: string;
  coverArtUrl?: string | null;
  createdAt: string;
  updatedAt: string;
};
