import { Box, Button, Container, Typography } from '@mui/material';
import GuideBook from '../GuideBook/GuideBook';
import { useAppSelector } from '../../redux/hooks';

export default function Enter() {
  const chapter = useAppSelector((state) => state.chapter);
  const imgSrc = `images/chapter${chapter.chapterId}.png`;

  console.log(chapter);
  return (
    <Container
      sx={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center'
      }}
    >
      <Box marginRight={20}>
        <Typography
          variant="h4"
          align="center"
          marginBottom={1}
          fontWeight={600}
        >
          Chapter {chapter.chapterId}
        </Typography>
        <Typography paragraph align="center" color="text.secondary">
          {chapter.title}
        </Typography>
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            marginTop: 10
          }}
        >
          <img
            src={imgSrc}
            style={{ width: '400px', height: '370px' }}
            alt="enterImg"
          />
          <Button
            variant="contained"
            size="large"
            color="primary"
            sx={{ marginTop: 10 }}
            disabled={chapter.chapterStatus}
          >
            {chapter.chapterStatus ? '학습완료' : '학습하기'}
          </Button>
        </Box>
      </Box>
      <GuideBook />
    </Container>
  );
}
