export type ArtistCreateDto = {
  name: string;
  surname: string;
  countryId?: number | null;
  cityId?: number | null;
  bio?: string | null;
  socialLinks?: Map<string, string> | null;
};

export type ArtistUpdateDto = {
  name: string;
  surname: string;
  countryId?: number | null;
  cityId?: number | null;
  bio?: string | null;
  socialLinks?: Map<string, string> | null;
};
export type ArtistResponseDto = {
  name: string;
  surname: string;
  countryId?: number | null;
  cityId?: number | null;
  bio?: string | null;
  socialLinks?: Map<string, string> | null;
  createdAt: string;
  updatedAt: string;
};

export type ArtistListItemDto = {
  name: string;
  surname: string;
  countryId?: number | null;
  cityId?: number | null;
  bio?: string | null;
  socialLinks?: Map<string, string> | null;
  createdAt: string;
  updatedAt: string;
};
