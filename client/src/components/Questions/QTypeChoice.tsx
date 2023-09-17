import { Box, Button, Stack, Typography } from '@mui/material';
import { Learning } from '../../interfaces/Learning.interface';
import SelectButton from '../Button/SelectButton';
import { playText } from '../../common/utils/speak';
import { useState } from 'react';
import { grey } from '@mui/material/colors';

export interface QTypeProps {
  question: Learning;
  handleChangeUserInput?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  handleClickUserInput?: (e: React.MouseEvent<HTMLElement>) => void;
  status: string;
}

export default function QTypeChoice(props: QTypeProps) {
  const question = props.question;
  const handleClickUserInput = props.handleClickUserInput!;
  const status = props.status;
  const [isThick, setIsThick] = useState<string>('');

  const handleClick = (e: React.MouseEvent<HTMLElement>, text: string) => {
    if (question.questionType !== 1) playText(text);

    setIsThick(e.currentTarget.innerText);
    handleClickUserInput(e);
  };
  function exampleRender() {
    return question.examples!.map((el, idx) => {
      return (
        <Button
          key={idx}
          disabled={status === 'clicked'}
          onClick={(e: React.MouseEvent<HTMLElement>) => handleClick(e, el)}
          variant="outlined"
          color="primary"
          style={{
            borderWidth: el === isThick ? '3px' : '',
            borderColor: el === isThick ? '' : grey[500],
            color: el === isThick ? '' : grey[800],
            width: '170px',
            height: '90px',
            fontSize: '1.1em',
            textTransform: 'none',
            boxShadow:
              el === isThick
                ? 'rgba(66, 165, 245, 0.3) 0px 0.5rem 1.25rem'
                : 'rgba(0, 0, 0, 0.2) 0px 0px 10px'
          }}
        >
          {el}
        </Button>
      );
    });
  }

  function titleRender() {
    const splitStr = question.question.split('_');

    switch (question.questionType) {
      case 1:
        return (
          <>
            <Typography variant="h4">
              단어에 알맞은 의미를 선택하세요.
            </Typography>
            <Box
              sx={{
                backgroundColor: 'rgba(66, 165, 245, 0.2)',
                padding: '20px 40px',
                borderRadius: '5px'
              }}
            >
              <Typography variant="h6">{question.question}</Typography>
            </Box>
          </>
        );
      case 2:
        return (
          <>
            <Typography variant="h4">
              의미에 알맞은 단어를 선택하세요.
            </Typography>
            <Box
              sx={{
                backgroundColor: 'rgba(66, 165, 245, 0.2)',
                padding: '20px 40px',
                borderRadius: '5px'
              }}
            >
              <Typography variant="h6">{question.question}</Typography>
            </Box>
          </>
        );
      case 4:
        return (
          <>
            <Typography variant="h4">문장의 빈칸을 채우세요.</Typography>
            <Box
              sx={{
                backgroundColor: 'rgba(66, 165, 245, 0.2)',
                padding: '20px 40px',
                borderRadius: '5px'
              }}
            >
              <Stack flexDirection={'row'}>
                <Typography variant="h6">{splitStr[0]}</Typography>
                <Box
                  sx={{
                    width: '100px',
                    backgroundColor: '#fff',
                    borderRadius: '5px',
                    margin: '0 8px',
                    borderWidth: 1,
                    borderStyle: 'dashed',
                    borderColor: grey[500]
                  }}
                />
                <Box>
                  <Typography variant="h6">{splitStr[1]}</Typography>
                </Box>
              </Stack>
              <Typography
                variant="body2"
                textAlign={'center'}
                mt={2}
                color={grey[600]}
              >
                {question.translation}
              </Typography>
            </Box>
          </>
        );
      default:
        return null;
    }
  }
  return (
    <Box
      sx={{
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center'
      }}
    >
      <Stack gap={6} mb={10} justifyContent={'center'} alignItems={'center'}>
        {titleRender()}
      </Stack>
      <Stack flexDirection={'row'} justifyContent={'space-between'} gap={6}>
        {exampleRender()}
      </Stack>
    </Box>
  );
}
