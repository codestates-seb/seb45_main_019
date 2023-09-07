/* eslint-disable jsx-a11y/no-autofocus */
import React, { useState } from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { alpha, createTheme, ThemeProvider } from '@mui/material/styles';
import api from '../../common/utils/api';
import Input from './Input';
import Copyright from '../../components/Copyright/Copyright';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { GlobalContainer } from '../../style/Global.styled';
import { useNavigate, Link as RouterLink } from 'react-router-dom';
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
// console.log(defaultTheme);

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
                    Sign Up
                  </Typography>
                </Box>
              </Box>
              <Box
                component="form"
                noValidate
                onSubmit={handleSubmit}
                sx={{
                  mt: 1,
                  padding: '24px'
                }}
              >
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
                  margin="normal"
                ></Input>

                <Input
                  autoComplete=""
                  name="nickname"
                  required
                  id="nickname"
                  label="Nickname"
                  checkValid
                  isValid={nicknameIsValid}
                  setIsValid={setNicknameIsValid}
                  margin="normal"
                ></Input>

                <TextField
                  fullWidth
                  // eslint-disable-next-line jsx-a11y/no-autofocus
                  value={password}
                  onChange={handlePasswordChange}
                  autoComplete="new-password"
                  name="password"
                  required
                  id="password"
                  label="Password"
                  type="password"
                  margin="normal"
                />
                {passwordIsValid ? null : (
                  <Typography
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', mb: 0, fontSize: 12, pl: 1 }}
                  >
                    {passwordError}
                  </Typography>
                )}

                <TextField
                  fullWidth
                  // eslint-disable-next-line jsx-a11y/no-autofocus
                  value={passwordConfirm}
                  onChange={handlePasswordConfirmChange}
                  type="password"
                  id="password_confirm"
                  label="Confirm Password"
                  name="password_confirm"
                  required
                  margin="normal"
                />
                {passwordConfirmIsValid ? null : (
                  <Typography
                    display="block"
                    gutterBottom
                    sx={{ color: 'warning.main', pl: 1, mb: 0, fontSize: 12 }}
                  >
                    {passwordConfirmError}
                  </Typography>
                )}

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
                  margin="normal"
                ></Input>

                <FormControlLabel
                  control={
                    <Checkbox value="allowExtraEmails" color="primary" />
                  }
                  label="I want to receive inspiration, marketing promotions and updates via email."
                  sx={{ mt: 3 }}
                />

                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  sx={{ mt: 3, mb: 2 }}
                >
                  Sign Up
                </Button>
                <Link
                  component={RouterLink}
                  to="/signin"
                  sx={{
                    fontSize: 14,
                    display: 'block',
                    textAlign: 'center'
                  }}
                  underline="none"
                >
                  {'Already have an account? Sign in'}
                </Link>
              </Box>
            </Card>
          </Box>
          <Copyright sx={{ mt: 5 }} />
        </Container>
      </GlobalContainer>
    </ThemeProvider>
  );
}
