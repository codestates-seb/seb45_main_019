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

const style = {
  position: 'absolute' as const,
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 1000,
  bgcolor: 'background.paper',
  border: '2px solid #000',
  boxShadow: 24,
  p: 4
};
export default function GuideBook() {
  const [open, setOpen] = React.useState(false);
  const [selectedWordId, setSelectedWordId] = useState<number | null>(null);
  const handleOpen = (wordId: number) => {
    setSelectedWordId(wordId);
    setOpen(true);
  };
  const handleClose = () => setOpen(false);
  const chapter = useAppSelector((state) => state.chapter);

  return (
    <Box sx={{ width: '100%' }}>
      <div>
        {chapter.chapterWords.map((el) => (
          <div key={el}>
            <Card sx={{ width: '100%', marginBottom: '40px' }}>
              <CardHeader
                action={
                  <IconButton onClick={() => handleOpen(el)}>
                    <SearchIcon sx={{ color: 'primary.main' }} />
                  </IconButton>
                }
                title={`단어 ID : ${el}`}
                subheader="[발음기호]"
              />
              <CardContent>
                <Typography variant="body2" color="text.secondary">
                  1. 자본 2. 수도 3. 자금 4. 자산 5. 대문자
                </Typography>
              </CardContent>
              <CardActions>
                <Button>
                  <VolumeUpIcon />
                </Button>
                <Modal open={open} onClose={handleClose}>
                  <Box>
                    <Word wordInfo={word}></Word>
                  </Box>
                </Modal>
              </CardActions>
            </Card>
          </div>
        ))}
      </div>
    </Box>
  );
}
