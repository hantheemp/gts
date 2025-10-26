'use client';

import React from 'react';
import { StageCard } from '@/components/organisms/StageCard';
import { PopularityGuessForm } from '@/components/organisms/PopularityGuessForm';
import { useRouter } from 'next/navigation';
import { PopularityGuessData } from '@/lib/types';

export default function PopularityPage() {
  const router = useRouter();

  const handleSubmit = (data: PopularityGuessData) => {
    console.log('Popularity guess:', data);
    // TODO: Save to state/context/API
    router.push('/results');
  };

  return (
    <div className="relative flex min-h-screen w-full flex-col items-center justify-center bg-[#121212] p-4 sm:p-6 lg:p-8">
      <div className="w-full max-w-lg">
        <StageCard variant="pulse">
          <PopularityGuessForm
            songTitle="Solar Power"
            artistName="Lorde"
            onSubmit={handleSubmit}
          />
        </StageCard>
      </div>
    </div>
  );
}