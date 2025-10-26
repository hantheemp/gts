import React, { useState } from 'react';
import { StageProgress } from '../molecules/StageProgress';
import { HeadingPrimary } from '../atoms/HeadingPrimary';
import { BodyText } from '../atoms/BodyText';
import { FormField } from '../molecules/FormField';
import { InputText } from '../atoms/InputText';
import { SelectField } from '../atoms/SelectField';
import { RadioGroup } from '../molecules/RadioGroup';
import { ButtonPrimary } from '../atoms/ButtonPrimary';
import { GENRES, MOODS, LANGUAGES } from '@/lib/constants';
import { MusicGuessData } from '@/lib/types';

interface MusicGuessFormProps {
  onSubmit?: (data: MusicGuessData) => void;
}

export const MusicGuessForm: React.FC<MusicGuessFormProps> = ({ onSubmit }) => {
  const [formData, setFormData] = useState<MusicGuessData>({
    genre: '',
    mood: '',
    language: ''
  });

  const isValid = formData.genre && formData.mood && formData.language;

  return (
    <>
      <StageProgress currentStage={3} className="mb-6 p-4" />
      
      <div className="px-4 mb-8">
        <HeadingPrimary className="mb-3">Stage 3: Music Guess</HeadingPrimary>
        <BodyText muted>What&apos;s the vibe of this song?</BodyText>
      </div>

      <div className="flex flex-col gap-6 px-4">
        <FormField label="Genre">
          <InputText
            placeholder="e.g., Dream Pop, Shoegaze..."
            value={formData.genre}
            onChange={(e) => setFormData({ ...formData, genre: e.target.value })}
            list="genres"
          />
          <datalist id="genres">
            {GENRES.map(genre => (
              <option key={genre} value={genre} />
            ))}
          </datalist>
        </FormField>

        <div className="flex flex-col gap-2">
          <p className="text-white text-base font-medium leading-normal">Mood</p>
          <RadioGroup
            name="mood"
            options={MOODS}
            value={formData.mood}
            onChange={(value) => setFormData({ ...formData, mood: value })}
            variant="chip"
            className="pt-2"
          />
        </div>

        <FormField label="Language">
          <SelectField
            options={LANGUAGES}
            value={formData.language}
            onChange={(e) => setFormData({ ...formData, language: e.target.value })}
            placeholder="Select a language"
          />
        </FormField>

        <ButtonPrimary
          disabled={!isValid}
          onClick={() => onSubmit?.(formData)}
        >
          Continue
        </ButtonPrimary>
      </div>
    </>
  );
};