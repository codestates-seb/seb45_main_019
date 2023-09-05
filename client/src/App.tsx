import { Routes, Route } from 'react-router-dom';
import MainPage from './pages/Main/MainPage';
import { Container } from '@mui/material';
import SignUp from './pages/SignUp/SignUp';
import Header from './components/Header/Header';
import Learn from './pages/Learn/Learn';
export default function App() {
  return (
    <Container maxWidth={false} disableGutters>
      <Header />
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/learn" element={<Learn />} />
        <Route path="/signup" element={<SignUp></SignUp>} />
      </Routes>
    </Container>
  );
}
