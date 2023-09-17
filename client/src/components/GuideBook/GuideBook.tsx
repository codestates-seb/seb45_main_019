import {
  Box,
  Typography,
  Card,
  CardHeader,
  CardActions,
  CardContent,
  Button,
  IconButton
} from '@mui/material';
import { grey } from '@mui/material/colors';
import VolumeUpIcon from '@mui/icons-material/VolumeUp';
import SearchIcon from '@mui/icons-material/Search';
import { useAppSelector } from '../../redux/hooks';
import Modal from '@mui/material/Modal';
import React, { useState } from 'react';
import Word from '../Word/Word';
import { word } from '../../common/data/wordData';
import { getWordQueryKey, useWordQuery } from '../../queries/useWordQuery';
import Speaker from '../Speaker/Speaker';

// const style = {
//   position: 'absolute' as const,
//   top: '50%',
//   left: '50%',
//   transform: 'translate(-50%, -50%)',
//   width: 1000,
//   bgcolor: 'background.paper',
//   border: '2px solid #000',
//   boxShadow: 24,
//   p: 4
// };
export default function GuideBook() {
  const [open, setOpen] = React.useState(false);
  const [selectedWordId, setSelectedWordId] = useState(0);
  const handleOpen = (wordId: number) => {
    setSelectedWordId(wordId);
    setOpen(true);
  };
  const handleClose = () => setOpen(false);
  const chapter = useAppSelector((state) => state.chapter);

  return (
    <Box sx={{ width: '100%' }}>
      <div>
        {chapter.wordId.map((el) => (
          <WordCard key={el} handleOpen={handleOpen} wordId={el}></WordCard>
        ))}
        <Modal open={open} onClose={handleClose}>
          <Box
            sx={{
              position: 'absolute',
              top: '50%',
              left: '50%',
              transform: 'translate(-50%, -50%)'
            }}
          >
            <Word wordId={selectedWordId}></Word>
          </Box>
        </Modal>
      </div>
    </Box>
  );
}

interface WordCardProps {
  wordId: number;
  handleOpen: (wordId: number) => void;
}
const WordCard = ({ wordId, handleOpen }: WordCardProps) => {
  const queryKey = getWordQueryKey(wordId);
  const {
    isLoading: wordIsLoading,
    error,
    data: word
  } = useWordQuery(queryKey);

  if (wordIsLoading || !word || error) {
    return (
      <Card sx={{ width: '100%', marginBottom: '40px' }}>
        <CardHeader
          action={
            <IconButton onClick={() => null}>
              <SearchIcon sx={{ color: 'primary.main' }} />
            </IconButton>
          }
          title={`로딩중...`}
          // subheader="[...]"
        />
        <CardContent>
          <Typography variant="body2" color="text.secondary"></Typography>
        </CardContent>
        <CardActions>
          <Button>
            <VolumeUpIcon />
          </Button>
        </CardActions>
      </Card>
    );
  }

  return (
    <>
      <Card sx={{ width: '100%', marginBottom: '40px' }}>
        <CardHeader
          action={
            <IconButton onClick={() => handleOpen(wordId)}>
              <SearchIcon sx={{ color: 'primary.main' }} />
            </IconButton>
          }
          title={word.word}
          subheader={word.symbol}
        />
        <CardContent sx={{ display: 'flex', gap: 1 }}>
          {word.wordMeaning.map((el: string, key: number) => (
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
        </CardContent>
        <CardActions>
          <Button>
            <VolumeUpIcon />
          </Button>
        </CardActions>
      </Card>
      <Box
        sx={{
          width: '100%',
          marginBottom: '40px',
          background: 'white',
          boxShadow: (theme) => theme.shadows[1],
          p: 4,
          borderRadius: 1,
          '&:hover': {
            cursor: 'pointer',
            backgroundColor: 'action.hover'
          }
        }}
        onClick={() => handleOpen(wordId)}
      >
        <Box
          sx={{
            display: 'flex',
            gap: 1,
            alignItems: 'center'
          }}
        >
          <Typography
            sx={{
              fontWeight: 'fontWeightBold',
              fontSize: 35,
              color: 'text.primary'
            }}
          >
            {word.word}
          </Typography>
          <Typography
            sx={{
              fontWeight: 'fontWeightNormal',
              fontSize: 16,
              color: 'text.secondary'
            }}
          >
            {word.symbol}
          </Typography>
          <Box>
            <Speaker text={word.word}></Speaker>
          </Box>
        </Box>
        <Box sx={{ display: 'flex', gap: 1 }}>
          {word.wordMeaning.map((el: string, key: number) => (
            <Typography
              key={key}
              sx={{
                fontWeight: 'fontWeightBold',
                fontSize: 16,
                color: 'text.primary'
              }}
            >
              {`${key + 1}. ${el} `}
            </Typography>
          ))}
        </Box>
        <Box></Box>
      </Box>
    </>
  );
};
