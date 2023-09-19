const synth = window.speechSynthesis;
const utterance = new SpeechSynthesisUtterance();

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

const getDesiredVoice = (browserInfo: string) => {
  console.log(browserInfo);

  switch (browserInfo) {
    case 'Chrome':
      return 'Microsoft Christopher Online (Natural) - English (United States)';
    case 'Edge':
      return 'Microsoft Christopher Online (Natural) - English (United States)';
    case 'Safari':
      return 'Flo';
    default:
      console.log('currently tts is not supporting this browser.');
      return '';
  }
};
changeVoice();

synth.onvoiceschanged = () => {
  console.log('onvoiceschanged');
  changeVoice();
};

function changeVoice() {
  // const browserInfo = getBrowserInfo();
  // const desiredVoiceName = getDesiredVoice(browserInfo);

  // const desiredVoice = synth
  //   .getVoices()
  //   .find((voice) => voice.name === desiredVoiceName);
  // if (desiredVoice) {
  //   utterance.voice = desiredVoice;
  //   console.log('voice is set to: ', utterance.voice);
  // }

  // utterance.voice = {
  //   voiceURI:
  //     'Microsoft Christopher Online (Natural) - English (United States)',
  //   name: 'Microsoft Christopher Online (Natural) - English (United States)',
  //   lang: 'en-US',
  //   localService: false,
  //   default: false
  // };

  const voices = synth.getVoices();
  let voice = voices.find(
    (voice) =>
      voice.name ===
      'Microsoft Christopher Online (Natural) - English (United States)'
  );
  if (voice === undefined) {
    voice = voices.find((voice) => voice.name === 'Flo');
    if (voice === undefined) {
      voice = voices.find(
        (voice) => voice.name === 'Microsoft David - English (United States)'
      );
      if (voice === undefined) {
        voice = voices.find((voice) => voice.lang === 'en-US');
      }
    }
  }
  if (voice) {
    utterance.voice = voice;
    console.log('voice is set to: ', utterance.voice);
  } else {
    console.log('cannot set voice');
  }
}
export const playText = (text: string) => {
  utterance.text = text;
  synth.speak(utterance);
};
