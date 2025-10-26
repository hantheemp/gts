import React from 'react';

interface ButtonPrimaryProps {
  children: React.ReactNode;
  onClick?: () => void;
  disabled?: boolean;
  type?: 'button' | 'submit' | 'reset';
  className?: string;
  variant?: 'accent' | 'primary';
}

export const ButtonPrimary: React.FC<ButtonPrimaryProps> = ({
  children,
  onClick,
  disabled = false,
  type = 'button',
  className = '',
  variant = 'primary'
}) => {
  const baseClasses = "flex min-w-[84px] w-full cursor-pointer items-center justify-center overflow-hidden rounded-xl h-14 px-5 text-base font-bold leading-normal tracking-[0.015em] transition-all duration-300 font-display";
  const variantClasses = variant === 'accent' 
    ? "bg-[#00FFFF] text-black hover:bg-white hover:shadow-[0_0_15px_5px_rgba(0,255,255,0.3)]" 
    : "bg-primary text-white hover:shadow-[0_0_15px_#7f13ec,0_0_25px_#7f13ec]";
  const disabledClasses = "disabled:opacity-50 disabled:cursor-not-allowed disabled:shadow-none";
  
  return (
    <button
      type={type}
      onClick={onClick}
      disabled={disabled}
      className={`${baseClasses} ${variantClasses} ${disabledClasses} ${className}`}
    >
      <span className="truncate">{children}</span>
    </button>
  );
};