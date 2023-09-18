import { Box, Button, TextField, Typography } from '@mui/material';
import { QTypeProps } from './QTypeChoice';
import Speaker from '../Speaker/Speaker';
import RecordVoiceOverIcon from '@mui/icons-material/RecordVoiceOver';
import { playText } from '../../common/utils/speak';
export default function QTypeTyping(props: QTypeProps) {
  const question = props.question;
  const handleChange = props.handleChangeUserInput!;
  const status = props.status;
  return (
    <Box
      sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center'
      }}
    >
      <Typography variant="h4" mb={10}>
        음성을 듣고 단어를 작성하세요.
      </Typography>
      {/* 음성 출력 버튼 */}
      <Button
        variant="contained"
        onClick={() => playText(question.question)}
        sx={{
          width: '150px',
          height: '100px',
          backgroundColor: 'primary.main',
          mb: 5
        }}
      >
        <RecordVoiceOverIcon sx={{ width: '50px', height: '50px' }} />
      </Button>
      {/* 답 입력 공간 */}
      <TextField
        sx={{ width: '25em', backgroundColor: '#fff' }}
        disabled={status === 'clicked'}
        onChange={(e: React.ChangeEvent<HTMLInputElement>) => {
          return handleChange(e);
        }}
        variant="outlined"
        label="영어로 작성하세요."
        margin="normal"
        type="text"
        autoComplete="off"
        spellCheck={false}
      />
    </Box>
  );
}
