import {
  Box,
  ThemeProvider,
  Typography,
  createTheme,
  Button
} from '@mui/material';
import React, { useState } from 'react';
import Speaker from '../Speaker/Speaker';
import { useQuery } from '@tanstack/react-query';
import { AxiosError } from 'axios';
import api from '../../common/utils/api';
import AddWord from './AddWord';
const defaultTheme = createTheme();
console.log(defaultTheme);

export default function Word(props: { wordId: number }) {
  const [detailCategory, setDetailCategory] = useState(0);

  const { isLoading, error, data } = useQuery({
    queryKey: ['word', props.wordId],
    queryFn: () => api(`/words/${props.wordId}`).then(({ data }) => data.data)
  });

  if (isLoading) return <div> 로딩중... </div>;

  if (error) {
    const myError = error as AxiosError;
    return <div> 에러: {myError.message} </div>;
  }

  return (
    <ThemeProvider theme={defaultTheme}>
      <Box
        sx={{
          position: 'absolute',
          top: '50%',
          left: '50%',
          transform: 'translate(-50%, -50%)',
          backgroundColor: 'white',
          width: '55rem',
          height: '40rem',
          p: 4,
          display: 'flex',
          flexDirection: 'column',
          gap: 2,
          borderRadius: 4
        }}
      >
        <Box sx={{ display: 'flex', flexShrink: 1, gap: 1, alignItems: 'end' }}>
          <Typography
            variant="h3"
            fontWeight={'fontWeightBold'}
            sx={{
              color: 'text.primary'
            }}
          >
            {data.word}
          </Typography>
          <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
            <Typography>{data.symbol}</Typography>
            <Speaker text={data.word}></Speaker>
            <AddWord wordId={props.wordId}></AddWord>
          </Box>
        </Box>
        <Box sx={{ display: 'flex', flexShrink: 1, gap: 1 }}>
          {data.wordMeaning &&
            data.wordMeaning.map((el: string, key: number) => (
              <Typography
                variant="subtitle1"
                key={key}
                sx={{
                  color: 'text.primary',
                  fontWeight: 'fontWeightBold',
                  fontSize: 19
                }}
              >
                {`${key + 1}. ${el} `}
              </Typography>
            ))}
        </Box>
        <Box
          sx={{
            display: 'flex',
            flexShrink: 1,
            gap: 1
          }}
        >
          {data.detailCategories &&
            data.detailCategories.map((el: string, key: number) => (
              <Button
                key={key + '1234'}
                variant={detailCategory === key ? 'contained' : 'outlined'}
                onClick={() => setDetailCategory(key)}
              >
                {el}
              </Button>
            ))}

          <Button></Button>
        </Box>
        <Box sx={{ display: 'flex', flexGrow: 1, flexShrink: 9, gap: 2 }}>
          <Box
            sx={{
              flex: '1',
              p: 2,
              borderRadius: 2,
              // borderColor: 'primary.main',
              boxShadow: (theme) => theme.shadows[3]
            }}
          >
            {/* {wordInfo.detailDescriptions[detailCategory].map((el, key) => ( */}
            {data.detailDescriptions &&
              data.detailDescriptions.map((el: string, key: number) => (
                <Typography
                  variant="body1"
                  key={key}
                  sx={{
                    color: 'text.primary',
                    fontSize: 14,
                    fontWeight: 'fontWeightBold',
                    borderBottom: 1,
                    pb: 1,
                    mb: 1,
                    borderColor: 'grey.400'
                  }}
                >
                  {key + 1}. {el}{' '}
                </Typography>
              ))}
          </Box>
          <Box
            sx={{
              flex: '1',
              p: 2,
              borderRadius: 2,
              // borderColor: 'primary.main',
              boxShadow: (theme) => theme.shadows[3]
            }}
          >
            {data.wordExample &&
              data.wordExample.map((el: string, key: number) => (
                <Box
                  key={key}
                  sx={{ borderBottom: 1, mb: 1, borderColor: 'grey.400' }}
                >
                  <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
                    <Typography
                      variant="body1"
                      sx={{
                        color: 'text.primary',
                        fontSize: 14,
                        fontWeight: 'fontWeightBold'
                      }}
                    >
                      {el}{' '}
                    </Typography>
                    <Speaker text={el}></Speaker>
                  </Box>
                  <Box>
                    <Typography
                      variant="body1"
                      sx={{
                        color: 'text.primary',
                        mb: 1,
                        fontSize: 14,
                        fontWeight: 'fontWeightBold'
                      }}
                    >
                      {data.wordExampleMeaning[key]}
                    </Typography>
                  </Box>
                </Box>
              ))}
          </Box>
        </Box>
      </Box>
    </ThemeProvider>
  );
}
