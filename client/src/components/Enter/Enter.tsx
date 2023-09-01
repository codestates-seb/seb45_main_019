import { Box, Button, Container, Typography } from '@mui/material';

function Enter() {
  const imgSrc = `images/chapter${1}.png`;
  return (
    <Container
      sx={{
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center'
      }}
    >
      <Box>
        <Typography
          variant="h4"
          align="center"
          marginBottom={1}
          fontWeight={600}
        >
          Chapter 1
        </Typography>
        <Typography paragraph align="center" color="text.secondary">
          인사나누기
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
          >
            학습하기
          </Button>
        </Box>
      </Box>
    </Container>
  );
}

export default Enter;
