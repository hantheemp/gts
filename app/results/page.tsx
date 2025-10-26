'use client';

import React from 'react';
import { ButtonPrimary } from '@/components/atoms/ButtonPrimary';
import { BackgroundGrid } from '@/components/atoms/BackgroundGrid';
import { useRouter } from 'next/navigation';

export default function ResultsPage() {
  const router = useRouter();

  return (
    <div className="relative flex min-h-screen w-full flex-col items-center justify-center p-4 bg-[#10141C]">
      <BackgroundGrid />
      
      <div className="max-w-2xl text-center space-y-8">
        <h1 className="text-white text-6xl font-black leading-tight tracking-[-0.033em] font-display">
          Results Coming Soon!
        </h1>
        
        <p className="text-[#ab9db9] text-xl font-normal leading-relaxed">
          This page will show your score and accuracy for each guess.
        </p>
        
        <div className="flex flex-col sm:flex-row gap-4 justify-center mt-12">
          <ButtonPrimary onClick={() => router.push('/')}>
            Back to Home
          </ButtonPrimary>
        </div>
      </div>
    </div>
  );
}