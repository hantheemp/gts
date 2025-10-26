export interface Song {
  id: string;
  title: string;
  artist: string;
  audioUrl: string;
  coverArt: string;
  releaseYear: number;
  streams: number;
  monthlyListeners?: number;
  genre: string;
  mood: string;
  language: string;
  country: string;
  actType: string;
  activeSince: number;
}

export interface ArtistGuessData {
  originCountry: string;
  actType: string;
  activeSince: number;
}

export interface MusicGuessData {
  genre: string;
  mood: string;
  language: string;
}

export interface PopularityGuessData {
  cumulativeStreams: string;
  monthlyListeners: string;
  releaseYear: string;
  addToPlaylist: boolean;
}

export interface UserGuess {
  artist: ArtistGuessData;
  music: MusicGuessData;
  popularity: PopularityGuessData;
}

export interface GameState {
  currentStage: number;
  song: Song | null;
  guesses: Partial<UserGuess>;
  hasPlayed: boolean;
  startTime: Date;
  endTime?: Date;
}