import React from 'react';
import { HeadingSecondary } from '../atoms/HeadingSecondary';
import { BodyText } from '../atoms/BodyText';
import { ButtonPrimary } from '../atoms/ButtonPrimary';
import { AudioPlayer } from '../molecules/AudioPlayer';

interface ListenStageContentProps {
  imageUrl?: string;
  onReady?: () => void;
  isReady?: boolean;
}

export const ListenStageContent: React.FC<ListenStageContentProps> = ({
  imageUrl,
  onReady,
  isReady = false
}) => {
  return (
    <div className="flex flex-col items-center">
      <HeadingSecondary className="mb-4">Stage 1: Listen</HeadingSecondary>
      
      <div className="w-full aspect-square rounded-lg overflow-hidden mb-6">
        <img
          className="w-full h-full object-cover"
          src={imageUrl || '/placeholder.jpg'}
          alt="Blurred album art"
          style={{ filter: 'blur(40px) saturate(1.5)' }}
        />
      </div>

      <BodyText className="text-lg font-bold mb-6 text-center">
        Listen to today&apos;s 30-second clip.
      </BodyText>

      <div className="w-full max-w-xs mb-8">
        <AudioPlayer />
      </div>

      <ButtonPrimary disabled={!isReady} onClick={onReady} className="w-full">
        Ready to Guess
      </ButtonPrimary>
    </div>
  );
};