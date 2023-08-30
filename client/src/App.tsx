import { Routes, Route } from 'react-router-dom';
import MainPage from './pages/Main/MainPage';
import SignUp from './pages/SignUp/SignUp';

function App() {
  return (
    <Routes>
      <Route path="/" element={<MainPage />} />
      <Route path="/signup" element={<SignUp></SignUp>} />
    </Routes>
  );
}

export default App;
