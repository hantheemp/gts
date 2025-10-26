'use client';

import React from 'react';
import { BackgroundGrid } from '@/components/atoms/BackgroundGrid';
import { StageCard } from '@/components/organisms/StageCard';
import { ListenStageContent } from '@/components/organisms/ListenStageContent';
import { useRouter } from 'next/navigation';

export default function ListenPage() {
  const router = useRouter();
  const [isReady, setIsReady] = React.useState(false);

  React.useEffect(() => {
    // Simulate audio playing for 5 seconds before enabling button
    const timer = setTimeout(() => setIsReady(true), 5000);
    return () => clearTimeout(timer);
  }, []);

  const handleReady = () => {
    router.push('/stage/artist');
  };

  return (
    <div className="relative flex min-h-screen w-full flex-col items-center justify-center p-4 bg-[#10141C]">
      <BackgroundGrid />
      
      <div className="layout-container flex h-full grow flex-col justify-center w-full max-w-md">
        <div className="text-center mb-8">
          <h1 className="text-white text-4xl font-black leading-tight tracking-[-0.033em] font-display">
            Daily Indie Guess Challenge
          </h1>
        </div>

        <StageCard className="stage-card">
          <ListenStageContent
            imageUrl="https://images.unsplash.com/photo-1614854262318-831574f15f1f?w=400"
            isReady={isReady}
            onReady={handleReady}
          />
        </StageCard>
      </div>
    </div>
  );
}