import React from 'react';

interface StageCardProps {
  children: React.ReactNode;
  className?: string;
  variant?: 'default' | 'glow' | 'pulse';
}

export const StageCard: React.FC<StageCardProps> = ({
  children,
  className = '',
  variant = 'default'
}) => {
  const baseClasses = "rounded-xl p-6 sm:p-8";
  
  const variantClasses = {
    default: "bg-[#1E1E1E] shadow-2xl",
    glow: "bg-[#1E1E1E] shadow-2xl shadow-[0_0_15px_5px_rgba(127,19,236,0.4)]",
    pulse: "bg-[#1E1E1E] shadow-[0_0_15px_5px_rgba(0,255,255,0.3)] animate-[pulse-glow_3s_infinite_ease-in-out]"
  };

  return (
    <div className={`${baseClasses} ${variantClasses[variant]} ${className}`}>
      {children}
    </div>
  );
};