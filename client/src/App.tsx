import { Routes, Route } from 'react-router-dom';
import MainPage from './pages/Main/MainPage';
import { Container } from '@mui/material';
export default function App() {
  return (
    <Container
      sx={{
        display: 'flex',
        width: '100%'
      }}
      maxWidth={false}
      disableGutters
    >
      <Routes>
        <Route path="/" element={<MainPage />} />
      </Routes>
    </Container>
  );
}
