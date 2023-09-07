import { IconButton } from '@mui/material';
import RecordVoiceOverIcon from '@mui/icons-material/RecordVoiceOver';
import React from 'react';

export default function Speaker(props: { text: string }) {
  const synth = window.speechSynthesis;
  const utterance = new SpeechSynthesisUtterance();
  utterance.text = props.text;
  let desiredVoiceName = '';
  // Get the user agent string
  const userAgent = window.navigator.userAgent;

  // Check if the user agent string contains "Macintosh" (for macOS) or "Windows" (for Windows)
  if (userAgent.includes('Macintosh') || /iPhone|iPad/.test(userAgent)) {
    // It's macOS
    desiredVoiceName = 'Google UK English Female';
  } else if (userAgent.includes('Windows') || /Android/.test(userAgent)) {
    // It's Windows
    desiredVoiceName =
      'Microsoft Christopher Online (Natural) - English (United States)';
  } else {
    // It's neither macOS nor Windows (could be Linux or something else)
    console.log('This computer is running an unknown operating system.');
  }

  // Find the desired voice by name
  const voices = synth.getVoices();
  console.log(voices);

  const desiredVoice = synth
    .getVoices()
    .find((voice) => voice.name === desiredVoiceName);

  if (desiredVoice) {
    utterance.voice = desiredVoice;
  }

  const playText = () => {
    synth.speak(utterance);
  };
  return (
    <IconButton onClick={playText}>
      <RecordVoiceOverIcon></RecordVoiceOverIcon>
    </IconButton>
  );
}
