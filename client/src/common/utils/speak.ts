const synth = window.speechSynthesis;
const utterance = new SpeechSynthesisUtterance();
const desiredVoiceName =
  'Microsoft Christopher Online (Natural) - English (United States)';

synth.onvoiceschanged = () => {
  const desiredVoice = synth
    .getVoices()
    .find((voice) => voice.name === desiredVoiceName);
  if (desiredVoice) {
    utterance.voice = desiredVoice;
  }
};

export const playText = (text: string) => {
  utterance.text = text;
  synth.speak(utterance);
};
