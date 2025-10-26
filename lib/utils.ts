export const formatStreams = (streams: number): string => {
  if (streams >= 1000000000) {
    return `${(streams / 1000000000).toFixed(1)}B`;
  }
  if (streams >= 1000000) {
    return `${(streams / 1000000).toFixed(1)}M`;
  }
  if (streams >= 1000) {
    return `${(streams / 1000).toFixed(1)}K`;
  }
  return streams.toString();
};

export const parseStreams = (input: string): number => {
  const value = parseFloat(input);
  const unit = input.toUpperCase().slice(-1);
  
  switch (unit) {
    case 'B':
      return value * 1000000000;
    case 'M':
      return value * 1000000;
    case 'K':
      return value * 1000;
    default:
      return value;
  }
};

export const calculateAccuracy = (guess: number, actual: number): number => {
  const difference = Math.abs(guess - actual);
  const percentDiff = (difference / actual) * 100;
  return Math.max(0, 100 - percentDiff);
};

export const getScoreFromAccuracy = (accuracy: number): number => {
  if (accuracy >= 95) return 100;
  if (accuracy >= 85) return 90;
  if (accuracy >= 75) return 80;
  if (accuracy >= 65) return 70;
  if (accuracy >= 50) return 60;
  return Math.round(accuracy);
};