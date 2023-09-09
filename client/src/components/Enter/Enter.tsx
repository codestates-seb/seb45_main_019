import { Box, Button, Container, Typography } from '@mui/material';
import GuideBook from '../GuideBook/GuideBook';
import { useAppSelector } from '../../redux/hooks';
import { Link } from 'react-router-dom';
import { grey } from '@mui/material/colors';
import Progress from './MainProgress';

export default function Enter() {
  const chapter = useAppSelector((state) => state.chapter);

  function pointAcc() {
    let point = 0;

    for (let i = 0; i < chapter.progress!.length; i++) {
      if (chapter.progress![i] === 1) {
        if (i === 9 || i === 10 || i === 11) {
          point += 3;
        } else if (i === 3 || i === 6 || i === 9) {
          point += 2;
        } else {
          point += 1;
        }
      }
    }
    return point;
  }
  return (
    <Container
      sx={{
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'flex-start',
        gap: '5em',
        paddingTop: '4em',
        paddingBottom: '4em'
      }}
    >
      <Box
        sx={{
          borderRadius: '20px',
          boxShadow: 'rgba(66, 165, 245, 0.3) 0px 0.5rem 1.25rem',
          width: '100%',
          maxWidth: '400px',
          backgroundColor: '#fff'
        }}
      >
        <Box
          sx={{
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            background:
              'linear-gradient(to bottom, rgba(50,144,202,1) 0%,rgba(50,144,202,0.92) 47%,rgba(46,148,203,0.91) 51%,rgba(2,202,209,1) 100%)',
            height: '300px',
            borderRadius: '20px 20px 0 0'
          }}
        >
          <Typography
            variant="h6"
            gutterBottom
            sx={{ marginBottom: '15px', color: '#fff' }}
          >
            Chapter {chapter.chapterId}
          </Typography>
          <Box
            sx={{
              backgroundColor: '#fff',
              display: 'flex',
              flexDirection: 'column',
              justifyContent: 'center',
              alignItems: 'center',
              borderRadius: '120px',
              height: '120px',
              width: '120px',
              boxShadow: 'rgba(0, 0, 0, 0.2) 0px 0px 10px'
            }}
          >
            <Typography variant="h4" color={grey[700]}>
              {pointAcc()}
            </Typography>
            <Typography variant="subtitle2" color={grey[700]}>
              포인트
            </Typography>
          </Box>
        </Box>

        <Progress progress={chapter.progress!} />
        {/* <Link to="/learn" style={{ color: '#fff' }}>
            <Button
              variant="contained"
              size="large"
              color="primary"
              sx={{ marginTop: 10 }}
              disabled={chapter.chapterStatus}
            >
              {chapter.chapterStatus ? '학습완료' : '학습하기'}
            </Button>
          </Link> */}
      </Box>
      <GuideBook />
    </Container>
  );
}
