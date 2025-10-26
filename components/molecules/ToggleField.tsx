import React from 'react';
import { ToggleSwitch } from '../atoms/ToggleSwitch';

interface ToggleFieldProps {
  label: string;
  checked?: boolean;
  onChange?: (checked: boolean) => void;
  className?: string;
}

export const ToggleField: React.FC<ToggleFieldProps> = ({
  label,
  checked,
  onChange,
  className = ''
}) => {
  return (
    <div className={`flex flex-col items-start justify-between gap-4 rounded-xl border border-gray-700 bg-transparent p-5 sm:flex-row sm:items-center ${className}`}>
      <p className="text-base font-bold leading-tight text-white">{label}</p>
      <ToggleSwitch checked={checked} onChange={onChange} />
    </div>
  );
};