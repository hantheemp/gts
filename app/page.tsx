"use client";

import Countdown from "@/Components/Countdown/Countdown";

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-12">
      <Countdown />
    </main>
  );
}