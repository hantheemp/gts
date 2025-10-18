"use client";

import { useState, useEffect, useRef } from "react";

type CategoryState = "correct" | "partial" | "incorrect" | null;

type SongSelection = Record<number, string>;
type SongStates = Record<number, CategoryState>;

type Category = {
  title: string;
  hint: string;
  options: string[];
  answer: string;
};

type Song = {
  title: string;
  cover: string;
  audio: string;
  categories: Category[];
};

export default function Home() {
  const songs: Song[] = [
    {
      title: "Maxon",
      cover: "/covers/maxon.jpg",
      audio: "/songs/blindinglights.mp3",
      categories: [
        { title: "Artist Type", hint: "Solo / Group / Duo", options: ["Solo", "Group", "Duo"], answer: "Solo" },
        { title: "Genre", hint: "Dream Pop / Lo-fi / Synthwave", options: ["Dream Pop", "Lo-fi", "Synthwave"], answer: "Synthwave" },
        { title: "Country", hint: "USA / UK / Canada / France", options: ["USA", "UK", "Canada", "France"], answer: "Canada" },
        { title: "Mood", hint: "Melancholic / Energetic / Romantic", options: ["Melancholic", "Energetic", "Romantic"], answer: "Melancholic" },
        { title: "Instrument Focus", hint: "Guitar / Synth / Bass / Vocal", options: ["Guitar", "Synth", "Bass", "Vocal"], answer: "Synth" },
        { title: "Year", hint: "2013 / 2015 / 2018 / 2020", options: ["2013", "2015", "2018", "2020"], answer: "2018" },
      ],
    },
    {
      title: "Danza Kuduro",
      cover: "/covers/omar.png",
      audio: "/songs/maestro.mp3",
      categories: [
        { title: "Artist Type", hint: "Solo / Group / Duo", options: ["Solo", "Group", "Duo"], answer: "Group" },
        { title: "Genre", hint: "Dream Pop / Lo-fi / Synthwave", options: ["Dream Pop", "Lo-fi", "Synthwave"], answer: "Lo-fi" },
        { title: "Country", hint: "USA / UK / Canada / France", options: ["USA", "UK", "Canada", "France"], answer: "UK" },
        { title: "Mood", hint: "Melancholic / Energetic / Romantic", options: ["Melancholic", "Energetic", "Romantic"], answer: "Energetic" },
        { title: "Instrument Focus", hint: "Guitar / Synth / Bass / Vocal", options: ["Guitar", "Synth", "Bass", "Vocal"], answer: "Bass" },
        { title: "Year", hint: "2013 / 2015 / 2018 / 2020", options: ["2013", "2015", "2018", "2020"], answer: "2015" },
      ],
    },
    {
      title: "Emre Koyulunca",
      cover: "/covers/emrekoyulunca.png",
      audio: "/songs/lapsekilitayfur.mp3",
      categories: [
        { title: "Artist Type", hint: "Solo / Group / Duo", options: ["Solo", "Group", "Duo"], answer: "Duo" },
        { title: "Genre", hint: "Dream Pop / Lo-fi / Synthwave", options: ["Dream Pop", "Lo-fi", "Synthwave"], answer: "Dream Pop" },
        { title: "Country", hint: "USA / UK / Canada / France", options: ["USA", "UK", "Canada", "France"], answer: "USA" },
        { title: "Mood", hint: "Melancholic / Energetic / Romantic", options: ["Melancholic", "Energetic", "Romantic"], answer: "Romantic" },
        { title: "Instrument Focus", hint: "Guitar / Synth / Bass / Vocal", options: ["Guitar", "Synth", "Bass", "Vocal"], answer: "Guitar" },
        { title: "Year", hint: "2013 / 2015 / 2018 / 2020", options: ["2013", "2015", "2018", "2020"], answer: "2020" },
      ],
    },
    {
      title: "Capko Haykin",
      cover: "/covers/kurbik.png",
      audio: "/songs/kurbik.mp3",
      categories: [
        { title: "Artist Type", hint: "Solo / Group / Duo", options: ["Solo", "Group", "Duo"], answer: "Solo" },
        { title: "Genre", hint: "Dream Pop / Lo-fi / Synthwave", options: ["Dream Pop", "Lo-fi", "Synthwave"], answer: "Synthwave" },
        { title: "Country", hint: "USA / UK / Canada / France", options: ["USA", "UK", "Canada", "France"], answer: "France" },
        { title: "Mood", hint: "Melancholic / Energetic / Romantic", options: ["Melancholic", "Energetic", "Romantic"], answer: "Melancholic" },
        { title: "Instrument Focus", hint: "Guitar / Synth / Bass / Vocal", options: ["Guitar", "Synth", "Bass", "Vocal"], answer: "Vocal" },
        { title: "Year", hint: "2013 / 2015 / 2018 / 2020", options: ["2013", "2015", "2018", "2020"], answer: "2013" },
      ],
    },
  ];

  // --- State ---
  const [currentSongIndex, setCurrentSongIndex] = useState(0);
  const [isPlaying, setIsPlaying] = useState(false);
  const [openCard, setOpenCard] = useState<number | null>(null);
  const audioRef = useRef<HTMLAudioElement | null>(null);

  const [songSelections, setSongSelections] = useState<SongSelection[]>(
    songs.map((song) =>
      song.categories.reduce((acc, _, i) => ({ ...acc, [i]: "..." }), {})
    )
  );

  const [songStates, setSongStates] = useState<SongStates[]>(
    songs.map((song) =>
      song.categories.reduce((acc, _, i) => ({ ...acc, [i]: null }), {})
    )
  );

  const currentSong = songs[currentSongIndex];
  const currentSelections = songSelections[currentSongIndex];
  const currentStates = songStates[currentSongIndex];

  // --- Audio control ---
  useEffect(() => {
    if (audioRef.current) {
      isPlaying ? audioRef.current.play() : audioRef.current.pause();
    }
  }, [isPlaying, currentSongIndex]);

  const handleCardClick = (index: number) => {
    setOpenCard(openCard === index ? null : index);
  };

  const handleSelectOption = (categoryIndex: number, option: string) => {
    const updatedSelections = [...songSelections];
    updatedSelections[currentSongIndex][categoryIndex] = option;
    setSongSelections(updatedSelections);

    const updatedStates = [...songStates];
    const answer = currentSong.categories[categoryIndex].answer;
    updatedStates[currentSongIndex][categoryIndex] =
      option === answer ? "correct" : "incorrect";
    setSongStates(updatedStates);

    setOpenCard(null);
  };

  const handleNextSong = () => {
    setCurrentSongIndex((prev) => (prev < songs.length - 1 ? prev + 1 : 0));
    setOpenCard(null);
    setIsPlaying(false);
  };

  return (
    <main className="bg-gradient-to-b from-slate-950 to-slate-900 font-display text-white min-h-screen flex flex-col items-center justify-center p-4">
      <div className="w-full max-w-2xl">
        {/* Audio Player */}
        <div className="mb-8 rounded-lg bg-white/5 p-4 backdrop-blur-sm">
          <div className="flex items-center gap-4">
            <div
              className="h-16 w-16 shrink-0 rounded-lg bg-cover bg-center"
              style={{ backgroundImage: `url("${currentSong.cover}")` }}
            ></div>

            <div className="flex-1">
              <p className="text-lg font-bold">{currentSong.title}</p>
              <p className="text-sm text-white/60">Guess the song!</p>
            </div>

            <button
              onClick={() => setIsPlaying(!isPlaying)}
              className="flex h-12 w-12 shrink-0 items-center justify-center rounded-full bg-primary text-white transition-transform hover:scale-105 shadow-[0_0_10px_#2020df,0_0_20px_#2020df]"
            >
              {isPlaying ? (
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="currentColor"
                  viewBox="0 0 256 256"
                  width="24"
                  height="24"
                >
                  <rect x="80" y="48" width="32" height="160" rx="8"></rect>
                  <rect x="144" y="48" width="32" height="160" rx="8"></rect>
                </svg>
              ) : (
                <svg
                  fill="currentColor"
                  height="24"
                  viewBox="0 0 256 256"
                  width="24"
                  xmlns="http://www.w3.org/2000/svg"
                >
                  <path d="M240,128a15.74,15.74,0,0,1-7.6,13.51L88.32,229.65a16,16,0,0,1-16.2.3A15.86,15.86,0,0,1,64,216.13V39.87a15.86,15.86,0,0,1,8.12-13.82,16,16,0,0,1,16.2.3L232.4,114.49A15.74,15.74,0,0,1,240,128Z"></path>
                </svg>
              )}
            </button>
          </div>
          <audio ref={audioRef} src={currentSong.audio} />
        </div>

        {/* Category Cards */}
        <div className="grid grid-cols-2 gap-4 md:grid-cols-3 relative">
          {currentSong.categories.map((card, i) => {
            const value = currentSelections[i];
            const state = currentStates[i];
            const colors =
              state === "correct"
                ? "bg-[#28a745] shadow-[0_0_10px_#28a745]"
                : state === "partial"
                ? "bg-[#ffc107] shadow-[0_0_10px_#ffc107]"
                : state === "incorrect"
                ? "bg-[#dc3545] shadow-[0_0_10px_#dc3545]"
                : "bg-white/5 hover:bg-white/10";

            return (
              <div key={i} className="relative">
                <button
                  onClick={() => handleCardClick(i)}
                  className={`w-full group cursor-pointer rounded-lg p-4 text-center transition-all ${colors}`}
                >
                  <h3 className="font-bold text-white">{card.title}</h3>
                  <p className="text-sm text-white/60">{card.hint}</p>
                  <div className="mt-2 text-lg font-bold text-white">{value}</div>
                </button>

                {openCard === i && (
                  <div className="absolute top-full left-0 right-0 mt-2 bg-slate-700 border border-slate-600 rounded-lg shadow-2xl shadow-black/50 z-50 overflow-hidden">
                    {card.options.map((option, optIdx) => (
                      <button
                        key={optIdx}
                        onClick={() => handleSelectOption(i, option)}
                        className={`w-full px-4 py-3 text-left transition-all border-b border-slate-600 last:border-b-0 ${
                          value === option
                            ? "bg-gradient-to-r from-blue-500 to-purple-500 text-white font-semibold"
                            : "text-slate-200 hover:bg-slate-600/50"
                        }`}
                      >
                        {option}
                      </button>
                    ))}
                  </div>
                )}
              </div>
            );
          })}
        </div>

        <div className="mt-8 flex flex-col items-center gap-4 sm:flex-row sm:justify-between">
          <button
            onClick={handleNextSong}
            className="w-full rounded-full bg-primary px-8 py-3 font-bold text-white transition-transform hover:scale-105 sm:w-auto"
          >
            Next Song
          </button>
        </div>
      </div>

      {openCard !== null && (
        <div className="fixed inset-0 z-40" onClick={() => setOpenCard(null)} />
      )}
    </main>
  );
}
