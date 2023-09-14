import { Box, Button, Chip, Typography, createTheme } from '@mui/material';
import React, { useState } from 'react';
import Word from '../../components/Word/Word';
import { Progress } from './Progress';
import { Chapter } from '../../interfaces/Chapter.interface';
import { pointAcc } from '../../common/utils/pointCalculator';
import shadows from '@mui/material/styles/shadows';
import { Link } from 'react-router-dom';
import EastOutlinedIcon from '@mui/icons-material/EastOutlined';

const defaultTheme = createTheme();
interface ResultContentProps {
  QuestionData: Chapter;
}
export const ResultContent = ({ QuestionData }: ResultContentProps) => {
  const { chapterId, title, progress, wordId: wordIds } = QuestionData;

  const [selectedIndex, setSelectedIndex] = useState(0);

  const handleClick = (event: React.MouseEvent<HTMLButtonElement>) => {
    const id = event.currentTarget.id;

    if (id === 'previous') {
      setSelectedIndex(selectedIndex - 1);
      return;
    }
    if (id === 'next') {
      setSelectedIndex(selectedIndex + 1);
      return;
    }
  };

  return (
    <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2, mt: 10 }}>
      {/* <Box sx={{ display: 'flex', justifyContent: 'space-between' }}>
        <Typography
          variant="h4"
          sx={{
            fontWeight: 700
          }}
        >{`${chapterId}. ${title}`}</Typography>
        <Box sx={{ display: 'flex', alignItems: 'center', gap: 3 }}>
          <Chip
            label={`+ ${earnedPoints(progress)} Point`}
            color="success"
            sx={{
              fontSize: 17,
              fontWeight: 500,
              boxShadow: shadows[3],
              height: 0.9,
              borderRadius: 5
            }}
          />
          <Link to={'/main'}>
            <Button variant="contained">학습 완료</Button>
          </Link>
        </Box>
      </Box> */}
      <Box
        sx={{
          width: '100%',
          padding: '10px',
          borderRadius: '10px',
          display: 'flex',
          justifyContent: 'space-between',
          alignItems: 'center',
          background:
            'linear-gradient(to right, rgba(50,144,202,1) 0%,rgba(255,255,255,0.39) 61%,rgba(255,255,255,0) 100%)'
        }}
      >
        <Box>
          <Typography
            variant="h4"
            gutterBottom
            sx={{
              marginBottom: '15px',
              color: '#fff',
              fontFamily: 'Pacifico'
            }}
          >
            Chapter {chapterId}
          </Typography>
          <Typography variant="subtitle2" gutterBottom sx={{ color: '#fff' }}>
            {title}
          </Typography>
          <Typography variant="subtitle2" gutterBottom sx={{ color: '#fff' }}>
            {`+ ${earnedPoints(progress)} Point`}
          </Typography>
        </Box>
        <Box sx={{ display: 'flex', alignItems: 'center', gap: 3 }}>
          <Chip
            label={`+ ${earnedPoints(progress)} Point`}
            color="primary"
            variant="outlined"
            sx={{
              fontSize: 17,
              fontWeight: 500,
              boxShadow: shadows[3],
              borderRadius: 5,
              height: 40
            }}
          />
          <Link to={'/'}>
            <Button
              variant="contained"
              size="large"
              endIcon={<EastOutlinedIcon />}
            >
              학습 종료
            </Button>
          </Link>
        </Box>
        {/* )} */}
      </Box>
      <Box sx={{ display: 'flex', gap: 2 }}>
        <Box sx={{ display: 'flex', flexDirection: 'column', gap: 2 }}>
          <Word wordId={wordIds[selectedIndex]}></Word>
          <Box sx={{ display: 'flex', justifyContent: 'space-evenly' }}>
            <Button
              id="previous"
              onClick={handleClick}
              variant="contained"
              disabled={selectedIndex === 0}
            >
              이전
            </Button>
            <Button
              id="next"
              onClick={handleClick}
              variant="contained"
              disabled={selectedIndex === wordIds.length - 1}
            >
              다음
            </Button>
          </Box>
        </Box>
        {progress ? (
          <Progress
            progress={progress.slice(selectedIndex * 4, selectedIndex * 4 + 4)}
          />
        ) : (
          <Box>Not Available</Box>
        )}
      </Box>
    </Box>
  );
};

const earnedPoints = (progress: Chapter['progress']) => {
  if (progress) return pointAcc(progress);
  return 0;
};