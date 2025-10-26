import React from 'react';

interface SelectFieldProps {
  options: { value: string; label: string }[];
  value?: string;
  onChange?: (e: React.ChangeEvent<HTMLSelectElement>) => void;
  placeholder?: string;
  className?: string;
}

export const SelectField: React.FC<SelectFieldProps> = ({
  options,
  value,
  onChange,
  placeholder = 'Select an option',
  className = ''
}) => {
  return (
    <select
      value={value}
      onChange={onChange}
      className={`form-select flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-white focus:outline-0 focus:ring-2 focus:ring-primary border border-[#473b54] bg-[#211c27] h-14 placeholder:text-[#ab9db9] p-4 text-base font-normal leading-normal appearance-none bg-no-repeat bg-right ${className}`}
      style={{
        backgroundImage: "url('data:image/svg+xml,%3csvg xmlns=%27http://www.w3.org/2000/svg%27 width=%2724px%27 height=%2724px%27 fill=%27%23E0E0E0%27 viewBox=%270 0 256 256%27%3e%3cpath d=%27M215.39,92.61,139.39,168.61a8,8,0,0,1-11.32,0L52.61,92.61a8,8,0,0,1,11.32-11.32L128,144.69l64.07-63.4a8,8,0,0,1,11.32,11.32Z%27%3e%3c/path%3e%3c/svg%3e')",
        backgroundPosition: 'right 1rem center',
        backgroundSize: '1.5em 1.5em'
      }}
    >
      <option value="">{placeholder}</option>
      {options.map((option) => (
        <option key={option.value} value={option.value}>
          {option.label}
        </option>
      ))}
    </select>
  );
};