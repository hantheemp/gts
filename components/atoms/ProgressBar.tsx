import React from 'react';

interface ProgressBarProps {
  value: number;
  max?: number;
  className?: string;
  variant?: 'default' | 'gradient';
}

export const ProgressBar: React.FC<ProgressBarProps> = ({
  value,
  max = 100,
  className = '',
  variant = 'default'
}) => {
  const percentage = (value / max) * 100;
  const gradientClass = variant === 'gradient' ? 'bg-gradient-to-r from-[#9D00FF] to-[#00FFFF]' : 'bg-primary';
  
  return (
    <div className={`rounded-full bg-[#302839] h-2 overflow-hidden ${className}`}>
      <div
        className={`h-full rounded-full ${gradientClass} transition-all duration-300`}
        style={{ width: `${percentage}%` }}
      />
    </div>
  );
};