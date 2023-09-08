import { Routes, Route, useLocation } from 'react-router-dom';
import MainPage from './pages/Main/MainPage';
import { Container } from '@mui/material';
import SignUp from './pages/SignUp/SignUp';
import SignIn from './pages/SignIn/SignIn';

import Header from './components/Header/Header';
import Learn from './pages/Learn/Learn';
export default function App() {
  const location = useLocation().pathname;

  function handleHeaderVisible() {
    if (location === '/learn' || location === '/') {
      return null;
    }
    return <Header />;
  }

  return (
    <Container maxWidth={false} disableGutters>
      {handleHeaderVisible()}
      <Routes>
        <Route path="/" element={<MainPage />} />
        <Route path="/learn" element={<Learn />} />
        <Route path="/signup" element={<SignUp></SignUp>} />
        <Route path="/signin" element={<SignIn></SignIn>} />
      </Routes>
    </Container>
  );
}
