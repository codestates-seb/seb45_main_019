import { Box, Typography } from '@mui/material';
import React from 'react';
import CircleIcon from '@mui/icons-material/Circle';
import CheckCircleOutlineRoundedIcon from '@mui/icons-material/CheckCircleOutlineRounded';
import HighlightOffRoundedIcon from '@mui/icons-material/HighlightOffRounded';
interface ProgressProps {
  progress: (0 | 1 | 2)[];
}

export const Progress = ({ progress }: ProgressProps) => {
  const text = ['영단어 고르기', '뜻 고르기', '스펠링 입력하기', '빈칸 채우기'];
  return (
    <Box
      sx={{
        backgroundColor: 'white',
        width: '10rem',
        height: '40rem',
        p: 4,
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 4,
        boxShadow: (theme) => theme.shadows[3]
      }}
    >
      <Box
        sx={{
          display: 'flex',
          flexDirection: 'column',
          gap: 2,
          justifyContent: 'space-between',
          height: '100%'
        }}
      >
        {progress.map((el: number, index: number) => (
          <Box key={index} sx={{ textAlign: 'center' }}>
            <Typography
              sx={{
                fontSize: 13,
                fontWeight: 700
              }}
            >
              {text[index]}
            </Typography>
            {el === 1 ? (
              <CheckCircleOutlineRoundedIcon
                color="success"
                sx={{ fontSize: '5rem' }}
              />
            ) : (
              <HighlightOffRoundedIcon
                color="error"
                sx={{ fontSize: '5rem' }}
              />
            )}
            {/* <CircleIcon
              sx={{
                width: '5rem',
                // color: 'error.dark',
                color:
                  el === 1
                    ? 'success.main'
                    : el == 2
                    ? 'error.main'
                    : 'grey[300]',
                fontSize: 100,
                m: 0,
                p: 0
              }}
            /> */}
          </Box>
        ))}
      </Box>
    </Box>
  );
};
