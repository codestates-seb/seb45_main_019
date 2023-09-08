import { IconButton } from '@mui/material';
import RecordVoiceOverIcon from '@mui/icons-material/RecordVoiceOver';
import { playText } from './speak';

export default function Speaker(props: { text: string }) {
  return (
    <IconButton onClick={() => playText(props.text)}>
      <RecordVoiceOverIcon></RecordVoiceOverIcon>
    </IconButton>
  );
}
