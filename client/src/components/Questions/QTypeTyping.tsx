import { Box, TextField, Typography } from '@mui/material';
import { QTypeProps } from './QTypeChoice';

export default function QTypeTyping(props: QTypeProps) {
  const question = props.question;
  const handleChange = props.handleChangeUserInput!;
  const status = props.status;
  return (
    <Box sx={{ mt: 10 }}>
      <Typography></Typography>
      <Box sx={{ display: 'flex' }}>
        <TextField sx={{ width: '4rem' }}></TextField>
      </Box>
    </Box>
  );
}
