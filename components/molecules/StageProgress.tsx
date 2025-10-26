import React from 'react';
import { ProgressBar } from '../atoms/ProgressBar';

interface StageProgressProps {
  currentStage: number;
  totalStages?: number;
  className?: string;
}

export const StageProgress: React.FC<StageProgressProps> = ({
  currentStage,
  totalStages = 4,
  className = ''
}) => {
  const percentage = (currentStage / totalStages) * 100;

  return (
    <div className={`flex flex-col gap-3 ${className}`}>
      <div className="flex justify-between items-center">
        <p className="text-white text-base font-medium leading-normal">
          Stage {currentStage} of {totalStages}
        </p>
        <p className="text-white text-sm font-normal leading-normal">
          {Math.round(percentage)}%
        </p>
      </div>
      <ProgressBar value={currentStage} max={totalStages} />
    </div>
  );
};