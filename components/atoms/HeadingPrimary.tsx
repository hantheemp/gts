import React from 'react';

interface HeadingPrimaryProps {
  children: React.ReactNode;
  className?: string;
}

export const HeadingPrimary: React.FC<HeadingPrimaryProps> = ({ children, className = '' }) => {
  return (
    <h1 className={`text-white text-4xl font-black leading-tight tracking-[-0.033em] font-display ${className}`}>
      {children}
    </h1>
  );
};