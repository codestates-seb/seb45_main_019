import { Box, TextField } from '@mui/material';

// 효재님 이제 QType3 하시는거 같은데 제가 Questions쪽이
// 아직 안됐는데 문제 타입별로 컴포넌트에 문제 props를 내려줄
// 생각입니다. props로 받는 가정하에 문제 응답값에 맞는 처리만
//  해주시면 될거같아요. props는 문제 데이터, 문제 선택시 상태
//  변경 setState함수. 이렇게 두개 내려줄 생각입니다.
interface QTypeTypingProps {
  question: object;
  setState: () => void;
} //{ question }: QTypeTypingProps
export default function QTypeTyping() {
  return (
    <Box sx={{ mt: 10 }}>
      <p>입력문제</p>
      <Box sx={{ display: 'flex' }}>
        <TextField sx={{ width: '4rem' }}></TextField>
        <TextField sx={{ width: '4rem' }}></TextField>
        <TextField sx={{ width: '4rem' }}></TextField>
        <TextField sx={{ width: '4rem' }}></TextField>
        <TextField sx={{ width: '4rem' }}></TextField>
      </Box>
    </Box>
  );
}
