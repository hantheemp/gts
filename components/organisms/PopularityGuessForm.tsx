import React, { useState } from 'react';
import { HeadingPrimary } from '../atoms/HeadingPrimary';
import { BodyText } from '../atoms/BodyText';
import { FormField } from '../molecules/FormField';
import { InputText } from '../atoms/InputText';
import { ToggleField } from '../molecules/ToggleField';
import { ButtonPrimary } from '../atoms/ButtonPrimary';
import { PopularityGuessData } from '@/lib/types';

interface PopularityGuessFormProps {
  songTitle?: string;
  artistName?: string;
  onSubmit?: (data: PopularityGuessData) => void;
}

export const PopularityGuessForm: React.FC<PopularityGuessFormProps> = ({
  songTitle = 'Solar Power',
  artistName = 'Lorde',
  onSubmit
}) => {
  const [formData, setFormData] = useState<PopularityGuessData>({
    cumulativeStreams: '',
    monthlyListeners: '',
    releaseYear: '',
    addToPlaylist: false
  });

  const isValid = formData.cumulativeStreams && formData.releaseYear;

  return (
    <>
      <div className="text-center mb-8">
        <HeadingPrimary className="mb-2">Stage 4: Popularity Guess</HeadingPrimary>
        <BodyText className="text-[#00FFFF] font-medium">
          {songTitle} by {artistName}
        </BodyText>
      </div>

      <div className="space-y-6">
        <FormField label="Guess the Cumulative Streams" required>
          <InputText
            placeholder="e.g., 1.5M"
            value={formData.cumulativeStreams}
            onChange={(e) => setFormData({ ...formData, cumulativeStreams: e.target.value })}
          />
        </FormField>

        <FormField label="Guess the Spotify Monthly Listeners (Optional)">
          <InputText
            placeholder="e.g., 500K"
            value={formData.monthlyListeners}
            onChange={(e) => setFormData({ ...formData, monthlyListeners: e.target.value })}
          />
        </FormField>

        <FormField label="Guess the Release Year" required>
          <InputText
            type="number"
            placeholder="e.g., 2020"
            value={formData.releaseYear}
            onChange={(e) => setFormData({ ...formData, releaseYear: e.target.value })}
          />
        </FormField>

        <ToggleField
          label="Would you add this song to a playlist?"
          checked={formData.addToPlaylist}
          onChange={(checked) => setFormData({ ...formData, addToPlaylist: checked })}
        />
      </div>

      <div className="mt-10">
        <ButtonPrimary
          variant="accent"
          disabled={!isValid}
          onClick={() => onSubmit?.(formData)}
        >
          Reveal Results
        </ButtonPrimary>
      </div>
    </>
  );
};