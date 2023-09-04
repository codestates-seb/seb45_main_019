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
import Input from './Input';

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
  const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);
    console.log({
      email: data.get('email'),

      passwordConfirm: data.get('password_confirm'),
      nickname: data.get('nickname'),
      password: data.get('password')
    });
    if (data.get('password') === data.get('password_confirm')) {
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
                <Input
                  autoComplete=""
                  name="username"
                  required
                  id="username"
                  label="ID"
                ></Input>
              </Grid>
              <Grid item xs={12}>
                <Input
                  autoComplete=""
                  name="nickname"
                  required
                  id="nickname"
                  label="Nickname"
                ></Input>
              </Grid>
              <Grid item xs={12}>
                <Input
                  autoComplete="new-password"
                  name="password"
                  required
                  id="password"
                  label="Password"
                  type="password"
                ></Input>
              </Grid>
              <Grid item xs={12}>
                <Input
                  autoComplete=""
                  name="password_confirm"
                  required
                  id="password_confirm"
                  label="Confirm Password"
                  type="password"
                ></Input>
              </Grid>
              <Grid item xs={12}>
                <Input
                  autoComplete="email"
                  name="email"
                  required
                  id="email"
                  label="Email Address"
                  type="email"
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
