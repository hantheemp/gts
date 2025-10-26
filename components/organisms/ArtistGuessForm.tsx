import React, { useState } from 'react';
import { StageProgress } from '../molecules/StageProgress';
import { HeadingPrimary } from '../atoms/HeadingPrimary';
import { FormField } from '../molecules/FormField';
import { SelectField } from '../atoms/SelectField';
import { RadioGroup } from '../molecules/RadioGroup';
import { InputText } from '../atoms/InputText';
import { ButtonPrimary } from '../atoms/ButtonPrimary';
import { COUNTRIES, ACT_TYPES } from '@/lib/constants';
import { ArtistGuessData } from '@/lib/types';

interface ArtistGuessFormProps {
  onSubmit?: (data: ArtistGuessData) => void;
}

export const ArtistGuessForm: React.FC<ArtistGuessFormProps> = ({ onSubmit }) => {
  const [formData, setFormData] = useState<ArtistGuessData>({
    originCountry: '',
    actType: 'Solo',
    activeSince: 0
  });

  const isValid = formData.originCountry && formData.actType && formData.activeSince;

  return (
    <>
      <StageProgress currentStage={2} className="mb-6" />
      <HeadingPrimary className="text-center mb-8">Artist Guess</HeadingPrimary>
      
      <div className="space-y-6">
        <FormField label="Origin Country">
          <SelectField
            options={COUNTRIES}
            value={formData.originCountry}
            onChange={(e) => setFormData({ ...formData, originCountry: e.target.value })}
            placeholder="Select a country"
          />
        </FormField>

        <FormField label="Act Type">
          <RadioGroup
            name="act-type"
            options={ACT_TYPES}
            value={formData.actType}
            onChange={(value) => setFormData({ ...formData, actType: value })}
            variant="pill"
          />
        </FormField>

        <FormField label="Active Since">
          <InputText
            type="number"
            placeholder="Enter the year the artist/band formed"
            value={formData.activeSince || ''}
            onChange={(e) => setFormData({ ...formData, activeSince: parseInt(e.target.value) || 0 })}
          />
        </FormField>
      </div>

      <div className="mt-8">
        <ButtonPrimary
          disabled={!isValid}
          onClick={() => onSubmit?.(formData)}
        >
          Next
        </ButtonPrimary>
      </div>
    </>
  );
};