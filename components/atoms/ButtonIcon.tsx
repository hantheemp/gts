import React from 'react';

interface ButtonIconProps {
  icon: string;
  onClick?: () => void;
  size?: 'sm' | 'md' | 'lg';
  className?: string;
}

export const ButtonIcon: React.FC<ButtonIconProps> = ({
  icon,
  onClick,
  size = 'md',
  className = ''
}) => {
  const sizeClasses = {
    sm: 'size-10',
    md: 'size-12',
    lg: 'size-14'
  };
  
  return (
    <button
      onClick={onClick}
      className={`flex shrink-0 items-center justify-center rounded-full ${sizeClasses[size]} bg-primary text-white transition-all duration-300 hover:shadow-[0_0_15px_#7f13ec] ${className}`}
    >
      <span className="material-symbols-outlined text-3xl">{icon}</span>
    </button>
  );
};