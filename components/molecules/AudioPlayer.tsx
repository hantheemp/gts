import React from 'react';
import { ButtonIcon } from '../atoms/ButtonIcon';
import { ProgressBar } from '../atoms/ProgressBar';

interface AudioPlayerProps {
  isPlaying?: boolean;
  currentTime?: number;
  duration?: number;
  onPlayPause?: () => void;
  className?: string;
}

export const AudioPlayer: React.FC<AudioPlayerProps> = ({
  isPlaying = false,
  currentTime = 0,
  duration = 30,
  onPlayPause,
  className = ''
}) => {
  const formatTime = (seconds: number) => {
    const mins = Math.floor(seconds / 60);
    const secs = Math.floor(seconds % 60);
    return `${mins}:${secs.toString().padStart(2, '0')}`;
  };

  return (
    <div className={`flex flex-col gap-3 rounded-lg bg-black/30 px-4 py-3 ${className}`}>
      <div className="flex items-center gap-4">
        <ButtonIcon
          icon={isPlaying ? 'pause' : 'play_arrow'}
          onClick={onPlayPause}
        />
        <div className="flex-1">
          <ProgressBar value={currentTime} max={duration} variant="gradient" />
          <div className="flex items-center justify-between mt-1">
            <p className="text-[#ab9db9] text-xs font-medium leading-normal tracking-[0.015em]">
              {formatTime(currentTime)}
            </p>
            <p className="text-[#ab9db9] text-xs font-medium leading-normal tracking-[0.015em]">
              {formatTime(duration)}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};