import React from 'react';
import { RadioOption } from '../atoms/RadioOption';

interface RadioGroupOption {
  value: string;
  label: string;
}

interface RadioGroupProps {
  name: string;
  options: RadioGroupOption[];
  value?: string;
  onChange?: (value: string) => void;
  variant?: 'pill' | 'chip';
  className?: string;
}

export const RadioGroup: React.FC<RadioGroupProps> = ({
  name,
  options,
  value,
  onChange,
  variant = 'pill',
  className = ''
}) => {
  const containerClass = variant === 'pill'
    ? 'flex h-12 flex-1 items-center justify-center rounded-full bg-[#302839] p-1'
    : 'flex flex-wrap gap-3';

  return (
    <div className={`${containerClass} ${className}`}>
      {options.map((option) => (
        <RadioOption
          key={option.value}
          name={name}
          value={option.value}
          label={option.label}
          checked={value === option.value}
          onChange={(e) => onChange?.(e.target.value)}
          variant={variant}
        />
      ))}
    </div>
  );
};