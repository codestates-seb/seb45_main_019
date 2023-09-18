import { IconButton, ThemeProvider, createTheme } from '@mui/material';
import RecordVoiceOverIcon from '@mui/icons-material/RecordVoiceOver';
import { playText } from '../../common/utils/speak';
export default function Speaker(props: { text: string }) {
  return (
    <IconButton
      onClick={(event) => {
        event.stopPropagation();
        playText(props.text);
      }}
      sx={{ m: 0 }}
    >
      <RecordVoiceOverIcon sx={{ color: 'primary.main' }}></RecordVoiceOverIcon>
    </IconButton>
  );
}
