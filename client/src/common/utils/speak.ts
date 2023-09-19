const synth = window.speechSynthesis;
const utterance = new SpeechSynthesisUtterance();
synth.onvoiceschanged = () => {
  console.log('onvoiceschanged');

  const desiredVoice = synth
    .getVoices()
    .find((voice) => voice.name === desiredVoiceName);
  if (desiredVoice) {
    utterance.voice = desiredVoice;
    console.log('voice is set to: ', utterance.voice);
  }
};

function getBrowserInfo() {
  // Get the user agent string
  const userAgent = navigator.userAgent;

  // Define an array of known browser names and their corresponding regular expressions
  const browsers = [
    { name: 'Chrome', regex: /Chrome\/(\d+)/ },
    { name: 'Firefox', regex: /Firefox\/(\d+)/ },
    { name: 'Edge', regex: /Edge\/(\d+)/ },
    { name: 'Internet Explorer', regex: /Trident\/\d+\.\d+;.*rv:(\d+)/ },
    { name: 'Safari', regex: /Safari\/(\d+)/ }
  ];

  // Iterate through the array to find a match
  for (let i = 0; i < browsers.length; i++) {
    const browser = browsers[i];
    const match = userAgent.match(browser.regex);
    if (match) {
      return browser.name;
    }
  }

  // If no match is found, return "Unknown"
  return 'Unknown';
}

// Get and display the browser name and version
const browserInfo = getBrowserInfo();
const getDesiredVoice = (browserInfo: string) => {
  switch (browserInfo) {
    case 'Chrome':
      return 'Google US English';
    case 'Edge':
      return 'Microsoft Christopher Online (Natural) - English (United States)';
    case 'Safari':
      return 'Fred';
    default:
      console.log('currently tts is not supporting this browser.');
      return '';
  }
};
const desiredVoiceName = getDesiredVoice(browserInfo);

export const playText = (text: string) => {
  utterance.text = text;
  synth.speak(utterance);
};
