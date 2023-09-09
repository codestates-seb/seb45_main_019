import {
  Box,
  Typography,
  Card,
  CardHeader,
  CardActions,
  CardContent,
  Button
} from '@mui/material';
import { grey } from '@mui/material/colors';
import VolumeUpIcon from '@mui/icons-material/VolumeUp';
import SearchIcon from '@mui/icons-material/Search';
import { useAppSelector } from '../../redux/hooks';
import Modal from '@mui/material/Modal';
import React, { useState } from 'react';

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
            <Card
              sx={{ width: '100%', marginBottom: '16px', marginTop: '16px' }}
            >
              <CardHeader
                action={
                  <Button onClick={() => handleOpen(el)}>
                    <SearchIcon />
                  </Button>
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
                  <Box sx={style}>
                    <div style={{ display: 'flex', flexDirection: 'column' }}>
                      <div
                        style={{
                          display: 'flex',
                          justifyContent: 'space-between',
                          alignItems: 'center'
                        }}
                      >
                        <Typography
                          variant="h4"
                          color="text.secondary"
                        >{`단어 ID : ${selectedWordId}`}</Typography>
                        <Typography>(스피커)</Typography>
                        <Typography>[발음기호]</Typography>
                        <Button
                          variant="outlined"
                          style={{ marginLeft: '8px' }}
                        >
                          단어장 추가
                        </Button>
                      </div>
                      <Typography variant="body2" color="text.secondary">
                        1. 자본 2. 수도 3. 자금 4. 자산 5. 대문자
                      </Typography>
                      <div style={{ display: 'flex' }}>
                        <Button
                          variant="outlined"
                          style={{ marginRight: '8px' }}
                        >
                          명사
                        </Button>
                        <Button variant="outlined">형용사</Button>
                      </div>
                      <Box
                        sx={{
                          width: 300,
                          height: 300,
                          backgroundColor: 'primary.dark',
                          '&:hover': {
                            backgroundColor: 'primary.main',
                            opacity: [0.9, 0.8, 0.7]
                          }
                        }}
                      />
                    </div>
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
