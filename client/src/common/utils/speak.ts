const synth = window.speechSynthesis;
const utterance = new SpeechSynthesisUtterance();

changeVoice();

synth.onvoiceschanged = () => {
  changeVoice();
};

function changeVoice() {
  const voices = synth.getVoices();
  let voice = voices.find(
    (voice) =>
      voice.name ===
      'Microsoft Christopher Online (Natural) - English (United States)'
  );
  if (voice === undefined) {
    voice = voices.find((voice) => voice.name === 'Google US English');
    if (voice === undefined) {
      voice = voices.find(
        (voice) => voice.name === 'Microsoft David - English (United States)'
      );
      if (voice === undefined) {
        voice = voices.find(
          (voice) => voice.name === 'Samantha' && voice.lang === 'en-US'
        );
      }
    }
  }
  if (voice) {
    utterance.voice = voice;
  }
}

export const playText = (text: string) => {
  utterance.text = text;
  synth.speak(utterance);
};
