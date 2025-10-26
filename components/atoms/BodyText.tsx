import React from 'react';

interface BodyTextProps {
  children: React.ReactNode;
  className?: string;
  muted?: boolean;
}

export const BodyText: React.FC<BodyTextProps> = ({ children, className = '', muted = false }) => {
  const colorClass = muted ? 'text-[#ab9db9]' : 'text-white';
  return (
    <p className={`${colorClass} text-base font-normal leading-normal ${className}`}>
      {children}
    </p>
  );
};