import { Box } from '@mui/material';
import { QTypeProps } from './QTypeChoice';

export default function QTypeTyping(props: QTypeProps) {
  const question = props.question;
  const handleChange = props.handleChangeUserInput!;
  const status = props.status;
  return (
    <Box>
      {question.question}
      <input
        onChange={(e) => handleChange(e)}
        disabled={status === 'clicked'}
      />
    </Box>
  );
}
