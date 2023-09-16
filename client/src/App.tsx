import { Routes, Route, useLocation } from 'react-router-dom';
import MainPage from './pages/Main/MainPage';
import { Container } from '@mui/material';
import SignUp from './pages/SignUp/SignUp';
import SignIn from './pages/SignIn/SignIn';
import MyPage from './pages/MyPage/MyPage';
import Header from './components/Header/Header';
import Questions from './pages/Questions/Questions';
import WordPage from './pages/Word/WordPage';
import Result from './pages/Result/Result';
export default function App() {
  const { pathname: location } = useLocation();

  function handleHeaderVisible() {
    if (
      location === '/' ||
      location === '/learn/question' ||
      location === '/learn/result'
    ) {
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
        <Route path="/learn/result" element={<Result />} />
        <Route path="/signup" element={<SignUp></SignUp>} />
        <Route path="/signin" element={<SignIn></SignIn>} />
        <Route path="/my-word" element={<WordPage />} />
        <Route path="/my-page" element={<MyPage />} />
      </Routes>
    </Container>
  );
}
