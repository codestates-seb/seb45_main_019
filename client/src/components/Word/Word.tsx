import { Box, Typography, Button } from '@mui/material';
import React, { useState } from 'react';
import Speaker from '../Speaker/Speaker';
import { useQuery } from '@tanstack/react-query';
import { AxiosError } from 'axios';
import api from '../../common/utils/api';
import AddWord from './AddWord';
import { getWordQueryKey, useWordQuery } from '../../queries/useWordQuery';
import { WordInterface } from '../../interfaces/Word.interface';

export default function Word(props: { wordId: number }) {
  const queryKey = getWordQueryKey(props.wordId);
  const {
    isLoading: wordIsLoading,
    error,
    data: word
  } = useWordQuery(queryKey);

  if (wordIsLoading) {
    return <WordMsgBox text={`로딩중...`}></WordMsgBox>;
  }

  if (error || !word) {
    const myError = error as AxiosError;
    return <WordMsgBox text={`에러: ${myError.message}`}></WordMsgBox>;
  }

  return <WordInfo wordData={word} />;
}

interface WordMsgBoxProps {
  text: string;
}
const WordMsgBox = ({ text }: WordMsgBoxProps) => {
  return (
    <Box
      sx={{
        backgroundColor: 'white',
        width: '55rem',
        height: '40rem',
        p: 4,
        display: 'flex',
        flexDirection: 'column',
        gap: 2,
        borderRadius: 4,
        boxShadow: (theme) => theme.shadows[3]
      }}
    >
      {text}
    </Box>
  );
};

interface WordInfoProps {
  wordData: WordInterface;
}
const WordInfo = ({ wordData }: WordInfoProps) => {
  const {
    wordId,
    word,
    symbol,
    wordMeaning,
    detailDescriptions,
    wordExample,
    wordExampleMeaning
  } = wordData;

  const [detailCategory, setDetailCategory] = useState(0);
  return (
    <Box
      sx={{
        backgroundColor: 'white',
        width: '55rem',
        height: '40rem',
        p: 4,
        display: 'flex',
        flexDirection: 'column',
        gap: 2,
        borderRadius: 4,
        boxShadow: (theme) => theme.shadows[3]
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
          {word}
        </Typography>
        <Box
          sx={{
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'space-between',
            flex: 1
          }}
        >
          <Box sx={{ display: 'flex', alignItems: 'center', gap: 1 }}>
            <Typography
              sx={{
                fontWeight: 'fontWeightNormal',
                fontSize: 16,
                color: 'text.secondary'
              }}
            >
              {symbol}
            </Typography>
            <Speaker text={word}></Speaker>
          </Box>
          <AddWord wordId={wordId}></AddWord>
        </Box>
      </Box>
      <Box sx={{ display: 'flex', flexShrink: 1, gap: 2 }}>
        {wordMeaning &&
          wordMeaning.map((el: string, key: number) => (
            <Typography
              variant="subtitle1"
              key={key}
              sx={{
                color: 'text.primary',
                fontWeight: 'fontWeightSemiBold',
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
        {detailDescriptions &&
          detailDescriptions.map((el, key: number) => (
            <Button
              key={key}
              variant={detailCategory === key ? 'contained' : 'outlined'}
              onClick={() => setDetailCategory(key)}
            >
              {el.category}
            </Button>
          ))}
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
          {detailDescriptions
            ? detailDescriptions[detailCategory].descriptions.map((el, key) => (
                <Typography
                  variant="body1"
                  key={key}
                  sx={{
                    color: 'text.primary',
                    fontSize: 14,
                    fontWeight: 'fontWeightSemiBold',
                    borderBottom: 1,
                    pb: 2,
                    mb: 2,
                    borderColor: 'grey.300'
                  }}
                >
                  {key + 1}. {el}{' '}
                </Typography>
              ))
            : null}
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
          {wordExample &&
            wordExample.map((el: string, key: number) => (
              <Box
                key={key}
                sx={{ borderBottom: 1, mb: 2, borderColor: 'grey.300' }}
              >
                <Box sx={{ display: 'flex', alignItems: 'center', mb: 1 }}>
                  <Typography
                    variant="body1"
                    sx={{
                      color: 'text.primary',
                      fontSize: 14,
                      fontWeight: 'fontWeightSemiBold'
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
                      color: 'text.secondary',
                      mb: 1,
                      fontSize: 14,
                      fontWeight: 'fontWeightSemiBold'
                    }}
                  >
                    {wordExampleMeaning[key]}
                  </Typography>
                </Box>
              </Box>
            ))}
        </Box>
      </Box>
    </Box>
  );
};
