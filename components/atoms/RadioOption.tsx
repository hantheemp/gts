import React from 'react';

interface RadioOptionProps {
  name: string;
  value: string;
  label: string;
  checked?: boolean;
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  variant?: 'pill' | 'chip';
}

export const RadioOption: React.FC<RadioOptionProps> = ({
  name,
  value,
  label,
  checked,
  onChange,
  variant = 'pill'
}) => {
  const pillClasses = "flex cursor-pointer h-full grow items-center justify-center overflow-hidden rounded-full px-2 has-[:checked]:bg-primary/20 has-[:checked]:shadow-[0_0_4px_rgba(0,0,0,0.1)] has-[:checked]:text-white text-[#ab9db9] text-sm font-medium leading-normal transition-all";
  const chipClasses = "text-sm font-medium leading-normal flex items-center justify-center rounded-xl border border-[#473b54] px-4 h-11 text-white has-[:checked]:border-[3px] has-[:checked]:px-3.5 has-[:checked]:border-primary relative cursor-pointer";
  
  return (
    <label className={variant === 'pill' ? pillClasses : chipClasses}>
      <span className="truncate">{label}</span>
      <input
        type="radio"
        name={name}
        value={value}
        checked={checked}
        onChange={onChange}
        className="invisible w-0 absolute"
      />
    </label>
  );
};