/* eslint-disable jsx-a11y/no-autofocus */
import React, { useEffect, useState } from 'react';
import Button from '@mui/material/Button';
import CssBaseline from '@mui/material/CssBaseline';
import TextField from '@mui/material/TextField';
import Link from '@mui/material/Link';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Container from '@mui/material/Container';
import { alpha } from '@mui/material/styles';
import api from '../../common/utils/api';
import Input from './Input';
import FormControlLabel from '@mui/material/FormControlLabel';
import Checkbox from '@mui/material/Checkbox';
import { GlobalContainer } from '../../style/Global.styled';
import { useNavigate, Link as RouterLink } from 'react-router-dom';
import { Card, CardMedia } from '@mui/material';
import {
  localStorageGet,
  localStorageRemove
} from '../../common/utils/localStorageFuncs';
import { pointAcc } from '../../common/utils/pointCalculator';
import useSignUpMutation from '../../queries/useSignUpMutation';
import AlertDialog from '../../components/Dialogs/AlertDialog';
// TODO remove, this demo shouldn't need to reset the theme.

export default function SignUp() {
  const [password, setPassword] = useState('');
  const [passwordIsValid, setPasswordIsValid] = useState(true);
  const [passwordError, setPasswordError] = useState('');
  const [passwordConfirm, setPasswordConfirm] = useState('');
  const [passwordConfirmIsValid, setPasswordConfirmIsValid] = useState(true);
  const [passwordConfirmError, setPasswordConfirmError] = useState('');

  const [usernameIsValid, setUsernameIsValid] = useState(true);
  const [nicknameIsValid, setNicknameIsValid] = useState(true);

  const [dialogOpen, setdialogOpen] = useState(false);
  const [dialogTitle, setdialogTitle] = useState('');
  const [dialogContent, setdialogContent] = useState('');
  const [success, setSuccess] = useState(false);

  const { mutate } = useSignUpMutation();

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

    if (newValue === password) {
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
      password: data.get('password')
    };

    if (
      usernameIsValid &&
      passwordIsValid &&
      passwordConfirmIsValid &&
      nicknameIsValid &&
      info.username &&
      info.nickname &&
      info.password &&
      info.username.length > 0 &&
      info.nickname.length > 0 &&
      info.password.length > 0
    ) {
      api('/members', 'post', info)
        .then((res) => {
          if (res.data.status) {
            localStorageGet().data.map((el) => {
              const dataParam = {
                chapterStatus: el.chapterStatus,
                progress: el.progress,
                point: pointAcc(el.progress)
              };

              const param = {
                memberId: res.data.data.userId,
                chapterId: el.chapterId,
                data: dataParam
              };

              mutate(param);
            });
            localStorageRemove();

            setdialogOpen(true);
            setdialogTitle('회원가입 성공');
            setdialogContent('가입이 성공적으로 처리되었습니다.');
            setSuccess(true);
          } else {
            throw res;
          }
        })
        .catch((error) => {
          if (error.response.data.error === 900) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('존재하는 아이디 입니다.');
          } else if (error.response.data.error === 901) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('존재하는 닉네임 입니다.');
          } else if (error.response.data.error === 902) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('존재하는 이메일 입니다.');
          } else if (error.response.data.error === 903) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('아이디를 입력해주세요.');
          } else if (error.response.data.error === 904) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('아이디 형식이 맞지 않습니다.');
          } else if (error.response.data.error === 905) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('비밀번호를 입력해주세요.');
          } else if (error.response.data.error === 906) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('비밀번호가 형식에 맞지 않습니다.');
          } else if (error.response.data.error === 907) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('닉네임을 입력해주세요.');
          } else if (error.response.data.error === 908) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('닉네임이 형식에 맞지 않습니다.');
          } else if (error.response.data.error === 909) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('이메일을 입력해주세요.');
          } else if (error.response.data.error === 910) {
            setdialogOpen(true);
            setdialogTitle('회원가입 실패');
            setdialogContent('이메일이 형식에 맞지 않습니다.');
          } else {
            setdialogOpen(true);
            setdialogTitle('에러 발생');
            setdialogContent(error.response.data);
          }
        });
    } else {
      setdialogOpen(true);
      setdialogTitle('회원가입 실패');
      setdialogContent('정보를 올바르게 입력 해주세요.');
    }
  };

  return (
    <GlobalContainer>
      <AlertDialog
        open={dialogOpen}
        setOpen={setdialogOpen}
        title={dialogTitle}
        content={dialogContent}
        onConfirm={success ? () => navigate('/sign-in') : () => null}
      ></AlertDialog>
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
                alpha(theme.palette.primary.light, 0.5) + ` 0px 0.5rem 1.25rem`
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
                    alpha(theme.palette.common.black, 0.6),
                  p: (theme) => theme.spacing(3)
                }}
              >
                <Typography
                  variant={'h2'}
                  sx={{
                    color: 'common.white',
                    fontSize: '1.5rem',
                    mb: 0,
                    fontWeight: 400,
                    fontFamily: 'Pacifico'
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
                label="아이디"
                checkValid
                isValid={usernameIsValid}
                setIsValid={setUsernameIsValid}
                autoFocus
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
                label="비밀번호"
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
                label="비밀번호 확인"
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
                name="nickname"
                required
                id="nickname"
                label="닉네임"
                checkValid
                isValid={nicknameIsValid}
                setIsValid={setNicknameIsValid}
                margin="normal"
              ></Input>
              <Button
                type="submit"
                fullWidth
                variant="contained"
                sx={{ mt: 3, mb: 2 }}
              >
                회원가입
              </Button>
              <Link
                component={RouterLink}
                to="/sign-in"
                sx={{
                  fontSize: 13,
                  display: 'block',
                  textAlign: 'center',
                  textDecoration: 'underline'
                }}
                underline="none"
              >
                이미 계정이 있으신가요?
              </Link>
            </Box>
          </Card>
        </Box>
      </Container>
    </GlobalContainer>
  );
}
