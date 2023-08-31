import React, { useState } from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import api from '../../common/utils/api';

// eslint-disable-next-line @typescript-eslint/no-explicit-any
function Copyright(props: any) {
  return (
    <Typography
      variant="body2"
      color="text.secondary"
      align="center"
      {...props}
    >
      {'Copyright © '}
      <Link color="inherit" href="https://mui.com/">
        Your Website
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

// TODO remove, this demo shouldn't need to reset the theme.
const defaultTheme = createTheme();
console.log(defaultTheme);

export default function SignUp() {
  const [username, setUsername] = useState('');
  const [usernameIsValid, setUsernameIsValid] = useState(false);
  const handleUsername = (event: React.ChangeEvent<HTMLInputElement>) => {
    setUsername(event.target.value);
    event.target.value.length > 5 && event.target.value.length < 20
      ? setUsernameIsValid(true)
      : setUsernameIsValid(false);
  };

  const [nickname, setNickname] = useState('');
  const [nicknameIsValid, setNicknameIsValid] = useState(false);
  const handleNickname = (event: React.ChangeEvent<HTMLInputElement>) => {
    setNickname(event.target.value);
    event.target.value.length > 2
      ? setNicknameIsValid(true)
      : setNicknameIsValid(false);
  };

  const [password, setPassword] = useState('');
  const [passwordIsValid, setPasswordIsValid] = useState(false);
  const handlePassword = (event: React.ChangeEvent<HTMLInputElement>) => {
    setPassword(event.target.value);
    event.target.value.length > 2
      ? setPasswordIsValid(true)
      : setPasswordIsValid(false);
  };

  const [passwordConfirm, setPasswordConfirm] = useState('');
  const [passwordConfirmIsValid, setPasswordConfirmIsValid] = useState(false);
  const handlePasswordConfirm = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    setPasswordConfirm(event.target.value);
    event.target.value === password
      ? setPasswordConfirmIsValid(true)
      : setPasswordConfirmIsValid(false);
  };

  const [email, setEmail] = useState('');
  const [emailIsValid, setEmailIsValid] = useState(false);
  const handleEmail = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEmail(event.target.value);
    event.target.value.length > 2
      ? setEmailIsValid(true)
      : setEmailIsValid(false);
  };

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
      email: data.get('email'),
      username,
      password_confirm: data.get('password_confirm'),
      nickname: data.get('nickname'),
      password: data.get('password')
    });
    if (usernameIsValid) {
      api('/signup');
    }
  };

  return (
    <ThemeProvider theme={defaultTheme}>
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
          <Avatar sx={{ m: 1, bgcolor: 'secondary.main' }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign up
          </Typography>
          <Box
            component="form"
            noValidate
            onSubmit={handleSubmit}
            sx={{ mt: 3 }}
          >
            <Grid container rowSpacing={2}>
              <Grid item xs={12} sx={{ pt: '0px' }}>
                <TextField
                  autoComplete=""
                  name="username"
                  required
                  fullWidth
                  id="username"
                  label="ID"
                  // eslint-disable-next-line jsx-a11y/no-autofocus
                  autoFocus
                  value={username}
                  onChange={handleUsername}
                />
                {usernameIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    5~20 글자 영소문자, 숫자
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <TextField
                  autoComplete=""
                  name="nickname"
                  required
                  fullWidth
                  id="nickname"
                  label="Nickname"
                  // eslint-disable-next-line jsx-a11y/no-autofocus
                  autoFocus
                  value={nickname}
                  onChange={handleNickname}
                />
                {nicknameIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    5~20 글자
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="password"
                  label="Password"
                  type="password"
                  id="password"
                  autoComplete="new-password"
                  value={password}
                  onChange={handlePassword}
                />
                {passwordIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    8~20 글자 영문, 숫자, 특수문자 조합
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  name="password_confirm"
                  label="Confirm Password"
                  type="password"
                  id="password_confirm"
                  autoComplete=""
                  value={passwordConfirm}
                  onChange={handlePasswordConfirm}
                />
                {passwordConfirmIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    비밀번호가 일치 하지 않습니다.
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <TextField
                  required
                  fullWidth
                  id="email"
                  label="Email Address"
                  name="email"
                  autoComplete="email"
                  value={email}
                  onChange={handleEmail}
                />
                {emailIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    올바른 이메일 형식이 아닙니다.
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <FormControlLabel
                  control={
                    <Checkbox value="allowExtraEmails" color="primary" />
                  }
                  label="I want to receive inspiration, marketing promotions and updates via email."
                />
              </Grid>
            </Grid>
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Sign Up
            </Button>
            <Grid container justifyContent="flex-end">
              <Grid item>
                <Link href="/signin" variant="body2">
                  Already have an account? Sign in
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
        <Copyright sx={{ mt: 5 }} />
      </Container>
    </ThemeProvider>
  );
}
