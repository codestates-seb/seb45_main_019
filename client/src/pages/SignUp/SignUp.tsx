/* eslint-disable jsx-a11y/no-autofocus */
import React, { useState } from 'react';
import Avatar from '@mui/material/Avatar';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Grid from '@mui/material/Grid';
import Box from '@mui/material/Box';
import LockOutlinedIcon from '@mui/icons-material/LockOutlined';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import api from '../../common/utils/api';
import Input from './Input';
import { useNavigate } from 'react-router-dom';
import Copyright from '../../components/Copyright/Copyright';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';

// TODO remove, this demo shouldn't need to reset the theme.
const defaultTheme = createTheme();
console.log(defaultTheme);

export default function SignUp() {
  const [password, setPassword] = useState('');
  const [passwordIsValid, setPasswordIsValid] = useState(true);
  const [passwordError, setPasswordError] = useState('');
  const [passwordConfirm, setPasswordConfirm] = useState('');
  const [passwordConfirmIsValid, setPasswordConfirmIsValid] = useState(true);
  const [passwordConfirmError, setPasswordConfirmError] = useState('');
  const [emailIsValid, setEmailIsValid] = useState(true);
  const [usernameIsValid, setUsernameIsValid] = useState(true);
  const [nicknameIsValid, setNicknameIsValid] = useState(true);

  const handlePasswordChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const newValue = event.target.value;
    setPassword(newValue);

    if (
      newValue.match(
        /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/
      )
    ) {
      setPasswordIsValid(true);
      setPasswordError('');
    } else {
      setPasswordIsValid(false);
      setPasswordError('8~20 글자 영문, 숫자, 특수문자 조합');
    }
  };

  const handlePasswordConfirmChange = (
    event: React.ChangeEvent<HTMLInputElement>
  ) => {
    const newValue = event.target.value;
    setPasswordConfirm(newValue);

    if (newValue.match(password)) {
      setPasswordConfirmIsValid(true);
      setPasswordConfirmError('');
    } else {
      setPasswordConfirmIsValid(false);
      setPasswordConfirmError('비밀번호가 일치하지 않습니다.');
    }
  };

  const navigate = useNavigate();

  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    const info = {
      username: data.get('username'),
      nickname: data.get('nickname'),
      password: data.get('password'),
      // passwordConfirm: data.get('password_confirm'),
      email: data.get('email')
    };

    if (
      usernameIsValid &&
      passwordIsValid &&
      passwordConfirmIsValid &&
      emailIsValid &&
      nicknameIsValid &&
      info.username &&
      info.nickname &&
      info.password &&
      // info.passwordConfirm &&
      info.email &&
      info.username.length > 0 &&
      info.nickname.length > 0 &&
      info.password.length > 0 &&
      // info.passwordConfirm.length > 0 &&
      info.email.length > 0
    ) {
      api('/members', 'post', info)
        .then((res) => {
          console.log(res.data.msg);
          if (res.data.status) {
            alert('가입이 성공적으로 처리되었습니다.');
            navigate('/signin');
          }
        })
        .catch((error) => {
          alert(error);
        });
    } else {
      alert('정보를 올바르게 입력 해주세요.');
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
                <Input
                  autoComplete=""
                  name="username"
                  required
                  id="username"
                  label="ID"
                  checkValid
                  isValid={usernameIsValid}
                  setIsValid={setUsernameIsValid}
                  autoFocus
                ></Input>
              </Grid>
              <Grid item xs={12}>
                <Input
                  autoComplete=""
                  name="nickname"
                  required
                  id="nickname"
                  label="Nickname"
                  checkValid
                  isValid={nicknameIsValid}
                  setIsValid={setNicknameIsValid}
                ></Input>
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  // eslint-disable-next-line jsx-a11y/no-autofocus
                  autoFocus
                  value={password}
                  onChange={handlePasswordChange}
                  autoComplete="new-password"
                  name="password"
                  required
                  id="password"
                  label="Password"
                  type="password"
                />
                {passwordIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    {passwordError}
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <TextField
                  fullWidth
                  // eslint-disable-next-line jsx-a11y/no-autofocus
                  autoFocus
                  value={passwordConfirm}
                  onChange={handlePasswordConfirmChange}
                  type="password"
                  id="password_confirm"
                  label="Confirm Password"
                  name="password_confirm"
                  required
                />
                {passwordConfirmIsValid ? null : (
                  <Typography
                    variant="overline"
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', height: 10, pl: 1 }}
                  >
                    {passwordConfirmError}
                  </Typography>
                )}
              </Grid>
              <Grid item xs={12}>
                <Input
                  autoComplete=""
                  name="email"
                  required
                  id="email"
                  label="Email Address"
                  type="email"
                  checkValid
                  isValid={emailIsValid}
                  setIsValid={setEmailIsValid}
                ></Input>
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
