import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useQuery } from '@tanstack/react-query';
import api from '../../common/utils/api';
import TextField from '@mui/material/TextField';
import { AxiosError } from 'axios';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { useAppSelector } from '../../redux/hooks';

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

const centerStyle = {
  display: 'flex',
  justifyContent: 'center',
  marginTop: '70px'
};

const topMargin = {
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  marginTop: '20px'
};

export default function MyPage() {
  const userInfo = useAppSelector((state) => state.user);
  const { isLoading, error, data } = useQuery({
    queryKey: ['username', userInfo.userId],
    queryFn: () => api(`/members/${user}`, 'get').then(({ data }) => data.data)
  });
  if (isLoading)
    return (
      <Box
        sx={{
          backgroundColor: 'white',
          width: '55rem',
          height: '40rem',
          p: 4,
          display: 'flex',
          flexDirection: 'column',
          gap: 2,
          borderRadius: 4,
          boxShadow: (theme) => theme.shadows[3]
        }}
      >
        {' '}
        로딩중...{' '}
      </Box>
    );

  if (error) {
    const myError = error as AxiosError;
    return (
      <Box
        sx={{
          backgroundColor: 'white',
          width: '55rem',
          height: '40rem',
          p: 4,
          display: 'flex',
          flexDirection: 'column',
          gap: 2,
          borderRadius: 4,
          boxShadow: (theme) => theme.shadows[3]
        }}
      >
        {' '}
        에러: {myError.message}{' '}
      </Box>
    );
  }
  const [user, setUser] = useState(false);
  const [editedUser, setEditedUser] = useState({
    nickname: data.nickname,
    username: data.username,
    email: data.email
  });

  const handleEditClick = () => {
    setUser(true);
  };

  const handleReadClick = () => {
    setUser(false);
  };

  const handleFieldChange =
    (fieldName: string) => (event: React.ChangeEvent<HTMLInputElement>) => {
      setEditedUser({
        ...editedUser,
        [fieldName]: event.target.value
      });
    };

  return (
    <ThemeProvider theme={defaultTheme}>
      <div style={centerStyle}>
        <Card sx={{ minWidth: 1000 }}>
          <CardContent style={{ paddingLeft: '60px', paddingTop: '50px' }}>
            <Typography variant="h5" component="div">
              {data.username}
            </Typography>
            <Typography variant="body2">2023년 8월 28일 가입</Typography>
          </CardContent>

          <div style={centerStyle}>
            <Typography
              variant="h6"
              component="div"
              style={{ marginTop: '10px', marginRight: '50px' }}
            >
              닉네임
            </Typography>
            <TextField
              required={user}
              id="outlined-read-only-input"
              value={editedUser.nickname}
              onChange={handleFieldChange('nickname')}
              InputProps={{
                readOnly: !user
              }}
            />
          </div>

          <div style={topMargin}>
            <Typography
              variant="h6"
              component="div"
              style={{ marginRight: '50px' }}
            >
              아이디
            </Typography>
            <TextField
              required={user}
              id="outlined-read-only-input"
              value={editedUser.username}
              onChange={handleFieldChange('username')}
              InputProps={{
                readOnly: !user
              }}
            />
          </div>
          <div style={topMargin}>
            <Typography
              variant="h6"
              component="div"
              style={{ marginRight: '50px' }}
            >
              이메일
            </Typography>
            <TextField
              required={user}
              id="outlined-read-only-input"
              value={editedUser.email}
              onChange={handleFieldChange('email')}
              InputProps={{
                readOnly: !user
              }}
            />
          </div>
          <div
            style={{
              display: 'flex',
              justifyContent: 'flex-end',
              padding: '16px',
              marginTop: '80px'
            }}
          >
            <div style={centerStyle}>
              {!user && (
                <Button
                  variant="outlined"
                  style={{ marginLeft: '8px' }}
                  onClick={handleEditClick}
                >
                  내 정보 수정
                </Button>
              )}
              {user && (
                <Button
                  variant="outlined"
                  style={{ marginLeft: '8px' }}
                  onClick={handleReadClick}
                >
                  수정완료
                </Button>
              )}

              <Button variant="outlined" style={{ marginLeft: '8px' }}>
                계정 삭제
              </Button>
            </div>
          </div>
        </Card>
      </div>
    </ThemeProvider>
  );
}
