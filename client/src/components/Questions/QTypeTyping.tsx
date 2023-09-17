import { Box, Button, TextField, Typography } from '@mui/material';
import { QTypeProps } from './QTypeChoice';
import Speaker from '../Speaker/Speaker';

export default function QTypeTyping(props: QTypeProps) {
  const question = props.question;
  const handleChange = props.handleChangeUserInput!;
  const status = props.status;
  return (
    <Box sx={{ mt: 10 }}>
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'column',
          alignItems: 'center',
          justifyContent: 'center'
        }}
      >
        <Typography variant="h4" gutterBottom>
          음성을 듣고 단어를 입력하세요.
        </Typography>
        {/* 음성 출력 버튼 */}
        <Box>
          <Speaker text={`${question.question}`}></Speaker>
        </Box>
        {/* 답 입력 공간 */}
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center'
          }}
        >
          <TextField
            sx={{ width: '15rem', fontSize: '3rem' }}
            disabled={status === 'clicked'}
            onChange={(e: React.ChangeEvent<HTMLInputElement>) => {
              return handleChange(e);
            }}
            variant="outlined"
            label="영어로 입력하세요."
            margin="normal"
            required
            type="text"
          ></TextField>
        </Box>
      </Box>
    </Box>
  );
}
