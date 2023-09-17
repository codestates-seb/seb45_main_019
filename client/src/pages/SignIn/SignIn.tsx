/* eslint-disable jsx-a11y/no-autofocus */
import React, { useState } from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { alpha, createTheme, ThemeProvider } from '@mui/material/styles';
import Copyright from '../../components/Copyright/Copyright';
import api from '../../common/utils/api';
import { useAppDispatch } from '../../redux/hooks';
import { setUser } from '../../redux/slices/user';
import { useNavigate, Link as RouterLink } from 'react-router-dom';
import { GlobalContainer } from '../../style/Global.styled';
import { Card, CardMedia } from '@mui/material';
// TODO remove, this demo shouldn't need to reset the theme.
const defaultTheme = createTheme({
  components: {
    MuiFormControlLabel: {
      styleOverrides: {
        label: {
          fontSize: 14
        }
      }
    }
  }
});

export default function SignIn() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();
  const dispatch = useAppDispatch();
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (username.length > 0 && password.length > 0) {
      api('/members/login', 'post', { username, password })
        .then((res) => {
          if (res.data.status) {
            // eslint-disable-next-line camelcase
            const { email, username, userId, nickname, point, memberStatus } =
              res.data.data;

            dispatch(
              setUser({
                email: email,
                username: username,
                // eslint-disable-next-line camelcase
                userId: userId,
                nickname: nickname,
                point: point,
                memberStatus: memberStatus
              })
            );

            // localStorage.setItem('token', res.headers.Authorization);

            navigate('/');
          } else {
            throw res;
          }
        })
        .catch((error) => {
          // console.log(error);
          if (error.response.data.error === 911) {
            alert('해당 유저가 존재하지 않습니다.');
          } else if (error.response.data.error === 912) {
            alert('비밀번호가 일치하지 않습니다.');
          } else {
            console.log(error);
            alert(error);
          }
        });
    } else {
      alert('정보를 올바르게 입력해주세요.');
    }
  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <GlobalContainer>
        <Container component="main" maxWidth="xs">
          <CssBaseline />
          <Box
            sx={{
              marginTop: 8,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center'
            }}
          >
            <Box sx={{ mb: 3, display: 'inline-flex' }}>
              <Link
                component={RouterLink}
                to="/"
                underline="none"
                sx={{ display: 'inline-flex' }}
              >
                <img src={`images/main-logo.png`} alt="Jumbo React" />
              </Link>
            </Box>
            <Card
              sx={{
                maxWidth: '100%',
                width: 360,
                mb: 4,
                borderRadius: '12px',
                boxShadow: (theme) =>
                  alpha(theme.palette.primary.light, 0.5) +
                  ` 0px 0.5rem 1.25rem`
              }}
            >
              <Box sx={{ position: 'relative', height: '200px' }}>
                <CardMedia
                  component="img"
                  alt="green iguana"
                  height="200"
                  image={`images/sign.png`}
                />
                <Box
                  sx={{
                    flex: 1,
                    inset: 0,
                    position: 'absolute',
                    display: 'flex',
                    alignItems: 'center',
                    backgroundColor: (theme) =>
                      alpha(theme.palette.common.black, 0.5),
                    p: (theme) => theme.spacing(3)
                  }}
                >
                  <Typography
                    variant={'h2'}
                    sx={{
                      color: 'common.white',
                      fontSize: '1.5rem',
                      mb: 0,
                      fontWeight: 400
                    }}
                  >
                    Sign In
                  </Typography>
                </Box>
              </Box>

              <Box
                component="form"
                onSubmit={handleSubmit}
                noValidate
                sx={{
                  mt: 1,
                  padding: '24px'
                }}
              >
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  id="username"
                  label="ID"
                  name="username"
                  autoComplete="id"
                  autoFocus
                  value={username}
                  onChange={(event) => setUsername(event.target.value)}
                  sx={{}}
                />
                <TextField
                  margin="normal"
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="current-password"
                  value={password}
                  onChange={(event) => setPassword(event.target.value)}
                />
                <Link
                  component={RouterLink}
                  to="/"
                  style={{ fontSize: 14, display: 'block', textAlign: 'end' }}
                  underline="none"
                >
                  {'Forgot password?'}
                </Link>
                <FormControlLabel
                  control={<Checkbox value="remember" color="primary" />}
                  label="Remember me"
                />
                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Sign In
                </Button>
                <Link
                  component={RouterLink}
                  to="/signup"
                  sx={{
                    fontSize: 14,
                    display: 'block',
                    textAlign: 'center'
                  }}
                  underline="none"
                >
                  {"Don't have an account? Sign Up"}
                </Link>
              </Box>
            </Card>
          </Box>

          <Copyright sx={{ mt: 8, mb: 4 }} />
        </Container>
      </GlobalContainer>
    </ThemeProvider>
  );
}
