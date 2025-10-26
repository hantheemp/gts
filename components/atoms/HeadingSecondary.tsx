import React from 'react';

interface HeadingSecondaryProps {
  children: React.ReactNode;
  className?: string;
}

export const HeadingSecondary: React.FC<HeadingSecondaryProps> = ({ children, className = '' }) => {
  return (
    <h2 className={`text-white text-2xl font-bold leading-tight tracking-light font-display ${className}`}>
      {children}
    </h2>
  );
};