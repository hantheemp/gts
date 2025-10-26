import React from 'react';

export const BackgroundGrid: React.FC = () => {
  return (
    <div 
      className="fixed top-0 left-0 w-full h-full -z-10 bg-[#10141C]"
      style={{
        backgroundImage: 'linear-gradient(rgba(127, 19, 236, 0.3) 1px, transparent 1px), linear-gradient(90deg, rgba(127, 19, 236, 0.3) 1px, transparent 1px)',
        backgroundSize: '50px 50px',
        animation: 'grid-animation 10s linear infinite'
      }}
    />
  );
};