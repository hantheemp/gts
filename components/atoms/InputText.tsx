import React from 'react';

interface InputTextProps {
  placeholder?: string;
  value?: string;
  onChange?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  className?: string;
  type?: 'text' | 'number';
  list?: string;
}

export const InputText: React.FC<InputTextProps> = ({
  placeholder,
  value,
  onChange,
  className = '',
  type = 'text',
  list
}) => {
  return (
    <input
      type={type}
      list={list}
      placeholder={placeholder}
      value={value}
      onChange={onChange}
      className={`form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-white focus:outline-0 focus:ring-2 focus:ring-primary border border-[#473b54] bg-[#211c27] h-14 placeholder:text-[#ab9db9] p-4 text-base font-normal leading-normal ${className}`}
    />
  );
};