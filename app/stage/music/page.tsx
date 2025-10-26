'use client';

import React from 'react';
import { MusicGuessForm } from '@/components/organisms/MusicGuessForm';
import { useRouter } from 'next/navigation';
import { MusicGuessData } from '@/lib/types';

export default function MusicPage() {
  const router = useRouter();

  const handleSubmit = (data: MusicGuessData) => {
    console.log('Music guess:', data);
    // TODO: Save to state/context/API
    router.push('/stage/popularity');
  };

  return (
    <div className="relative flex min-h-screen w-full flex-col items-center justify-center bg-[#141118] p-4">
      <div className="layout-container flex h-full grow flex-col w-full max-w-[960px]">
        <div className="flex flex-1 justify-center py-5">
          <div className="layout-content-container flex flex-col w-full max-w-[480px] flex-1">
            <div className="flex flex-col gap-8">
              <MusicGuessForm onSubmit={handleSubmit} />
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}