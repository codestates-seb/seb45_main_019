import {
  AppBar,
  Box,
  Toolbar,
  Button,
  Container,
  Stack,
  IconButton,
  Tooltip
} from '@mui/material';
import { Link, useLocation } from 'react-router-dom';
import LogoutRoundedIcon from '@mui/icons-material/LogoutRounded';
import {
  AccountCircleRounded,
  BookRounded,
  LoginRounded
} from '@mui/icons-material';
import { useState } from 'react';
import Speaker from '../Speaker/Speaker';
export default function Header() {
  const location = useLocation().pathname;

  // TODO : 로그인 기능 완료 후 전역 상태로 변경
  const [loggedIn, setLoggedIn] = useState(false);

  // TODO: 로그아웃 처리
  const handleLogout = () => {
    console.log('log out');
  };

  if (location === '/learn') return null;

  return (
    <AppBar sx={{ backgroundColor: '#fff' }}>
      <Container maxWidth={false}>
        <Toolbar
          disableGutters
          sx={{
            display: 'flex',
            justifyContent: 'space-between',
            width: '100%'
          }}
        >
          <Link to="/">
            <img
              src="./images/main_logo1.png"
              alt="Main Logo"
              style={{ width: '200px' }}
            />
          </Link>
          <Stack direction={'row'} spacing={2}>
            <Link to="/">
              <Tooltip title="단어장">
                <IconButton
                  size="medium"
                  color={loggedIn ? 'primary' : 'default'}
                >
                  <BookRounded fontSize="inherit" />
                </IconButton>
              </Tooltip>
            </Link>
            <Link to="/">
              <Tooltip title="마이 페이지">
                <IconButton
                  size="medium"
                  color={loggedIn ? 'primary' : 'default'}
                >
                  <AccountCircleRounded fontSize="inherit" />
                </IconButton>
              </Tooltip>
            </Link>
            {loggedIn ? (
              <Tooltip title="로그아웃">
                <IconButton size="medium" onClick={handleLogout}>
                  <LogoutRoundedIcon fontSize="inherit" />
                </IconButton>
              </Tooltip>
            ) : (
              <Link to="/signin">
                <Tooltip title="로그인">
                  <IconButton size="medium" color="primary">
                    <LoginRounded fontSize="inherit" />
                  </IconButton>
                </Tooltip>
              </Link>
            )}
          </Stack>
        </Toolbar>
      </Container>
    </AppBar>
  );
}
