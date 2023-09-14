import { Box, Container } from '@mui/material';
import React from 'react';
import { useAppSelector } from '../../redux/hooks';
import { ResultContent } from './ResultContent';

export default function Result() {
  const QuestionData = useAppSelector((state) => state.chapter);

  if (!QuestionData) {
    return <Box>Not Available</Box>;
  }

  return (
    <Container
      sx={{
        display: 'flex'
      }}
    >
      <ResultContent QuestionData={QuestionData}></ResultContent>
    </Container>
  );
}
