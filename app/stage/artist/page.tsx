'use client';

import React from 'react';
import { StageCard } from '@/components/organisms/StageCard';
import { ArtistGuessForm } from '@/components/organisms/ArtistGuessForm';
import { useRouter } from 'next/navigation';
import { ArtistGuessData } from '@/lib/types';

export default function ArtistPage() {
  const router = useRouter();

  const handleSubmit = (data: ArtistGuessData) => {
    console.log('Artist guess:', data);
    // TODO: Save to state/context/API
    router.push('/stage/music');
  };

  return (
    <div className="relative flex min-h-screen w-full flex-col items-center justify-center bg-[#121212] p-4">
      <div className="w-full max-w-md">
        <StageCard variant="glow">
          <ArtistGuessForm onSubmit={handleSubmit} />
        </StageCard>
      </div>
    </div>
  );
}