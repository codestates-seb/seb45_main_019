import { Container, Stack } from '@mui/material';
import { Link } from 'react-router-dom';

export default function Learn() {
  return (
    <Container
      sx={{
        display: 'flex',
        width: '100%'
      }}
      maxWidth={false}
      disableGutters
    >
      <Stack>
        <h1>Learn .. </h1>
        <Link to="/">go home</Link>
      </Stack>
    </Container>
  );
}
