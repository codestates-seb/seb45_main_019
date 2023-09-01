import { Box, Container, Typography } from '@mui/material';

function Enter() {
  const imgSrc = `images/chapter${1}.png`;
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
          <img src={imgSrc} alt="enterImg" />
        </Box>
      </Box>
    </Container>
  );
}

export default Enter;
