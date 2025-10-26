import React from 'react';

interface ToggleSwitchProps {
  checked?: boolean;
  onChange?: (checked: boolean) => void;
  className?: string;
}

export const ToggleSwitch: React.FC<ToggleSwitchProps> = ({
  checked = false,
  onChange,
  className = ''
}) => {
  return (
    <label className={`relative flex h-8 w-14 cursor-pointer items-center rounded-full bg-[#333333] p-1 has-[:checked]:bg-[#00FFFF] transition-colors ${className}`}>
      <div className={`h-6 w-6 rounded-full bg-white transition-transform duration-300 ease-in-out ${checked ? 'translate-x-6' : ''}`} />
      <input
        type="checkbox"
        checked={checked}
        onChange={(e) => onChange?.(e.target.checked)}
        className="invisible absolute"
      />
    </label>
  );
};