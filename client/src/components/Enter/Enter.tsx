import { Box, Button, Container, Typography } from '@mui/material';
import GuideBook from '../GuideBook/GuideBook';
import { useAppSelector } from '../../redux/hooks';
import { Link } from 'react-router-dom';
import { grey } from '@mui/material/colors';
import MainProgress from '../Progress/MainProgress';
import CheckOutlinedIcon from '@mui/icons-material/CheckOutlined';
import EastOutlinedIcon from '@mui/icons-material/EastOutlined';
export default function Enter() {
  const chapter = useAppSelector((state) => state.chapter);

  console.log(chapter);
  function pointAcc() {
    let point = 0;

    for (let i = 0; i < chapter.progress!.length; i++) {
      if (chapter.progress![i] === 1) {
        if (i === 9 || i === 10 || i === 11) {
          point += 3;
        } else if (i === 2 || i === 5 || i === 8) {
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
        flexDirection: 'column',
        justifyContent: 'space-between',
        alignItems: 'flex-start',
        gap: '4em',
        paddingTop: '4em',
        paddingBottom: '4em'
      }}
    >
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
            Chapter {chapter.chapterId}
          </Typography>
          <Typography variant="subtitle2" gutterBottom sx={{ color: '#fff' }}>
            {chapter.title}
          </Typography>
        </Box>
        {chapter.chapterStatus ? (
          <Button
            variant="outlined"
            size="large"
            color="success"
            endIcon={<CheckOutlinedIcon />}
          >
            학습완료
          </Button>
        ) : (
          <Link to="/learn/question" style={{ color: '#fff' }}>
            <Button
              variant="contained"
              size="large"
              color="primary"
              endIcon={<EastOutlinedIcon />}
            >
              학습하기
            </Button>
          </Link>
        )}
      </Box>

      <Box
        sx={{
          width: '100%',
          display: 'flex',
          flexDirection: 'row',
          justifyContent: 'space-between',
          alignItems: 'flex-start',
          gap: '5em'
        }}
      >
        <GuideBook />
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

          <MainProgress progress={chapter.progress!} />
        </Box>
      </Box>
    </Container>
  );
}
