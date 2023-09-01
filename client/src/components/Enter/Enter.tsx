import { Box, Container, Typography } from '@mui/material';
// import SRZ from '../../common/images/chapter1.png';

function Enter() {
  // const imgSrc = `../../common/images/chapter1.png`;
  return (
    <Container>
      <Box>
        <Typography variant="h4" align="center" marginBottom={1}>
          Chapter 1
        </Typography>
        <Typography paragraph align="center" color="text.secondary">
          인사나누기
        </Typography>
        <Box>
          <img src="/images/chapter1.png" alt="enterImg" />
        </Box>
      </Box>
    </Container>
  );
}

export default Enter;
