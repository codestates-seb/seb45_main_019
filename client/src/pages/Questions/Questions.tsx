import { Box, Container, IconButton, Stack } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import QTypeChoice from '../../components/Questions/QTypeChoice';
import QTypeTyping from '../../components/Questions/QTypeTyping';
import Progress from '../../components/Progress/Progress';
export default function Questions() {
  const navigate = useNavigate();

  const handleExit = () => {
    const conf = confirm('학습을 종료하시겠습니까?');
    if (conf) {
      navigate('/');
    }
  };
  return (
    <Container
      sx={{
        display: 'flex',
        width: '100%',
        flexDirection: 'column'
      }}
      maxWidth={false}
      disableGutters
    >
      <Box sx={{ width: '100%', textAlign: 'right', padding: '20px' }}>
        <IconButton aria-label="delete" size="large" onClick={handleExit}>
          <CloseRoundedIcon fontSize={'large'} />
        </IconButton>
      </Box>
      <Container>
        <QTypeChoice />
        <QTypeTyping />
        <Progress />
      </Container>
    </Container>
  );
}
