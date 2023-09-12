import { Routes, Route, useLocation } from 'react-router-dom';
import MainPage from './pages/Main/MainPage';
import { Container } from '@mui/material';
import SignUp from './pages/SignUp/SignUp';
import SignIn from './pages/SignIn/SignIn';

import Header from './components/Header/Header';
import Questions from './pages/Questions/Questions';
import WordPage from './pages/Word/WordPage';
export default function App() {
  const location = useLocation().pathname;

  function handleHeaderVisible() {
    if (location === '/learn/question' || location === '/') {
      return null;
    }
    return <Header />;
  }

  return (
    <Container maxWidth={false} disableGutters>
      {handleHeaderVisible()}
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/learn/question" element={<Questions />} />
        <Route path="/signup" element={<SignUp></SignUp>} />
        <Route path="/signin" element={<SignIn></SignIn>} />
        <Route path="/my-word" element={<WordPage />} />
      </Routes>
    </Container>
  );
}
