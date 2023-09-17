import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import api from '../../common/utils/api';
import { alpha, createTheme, ThemeProvider } from '@mui/material/styles';
import TextField from '@mui/material/TextField';
import { AxiosError } from 'axios';

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
  marginTop: '80px'
};

const topMargin = {
  display: 'flex',
  justifyContent: 'center',
  alignItems: 'center',
  marginTop: '20px'
};

export default function MyPage() {
  const [editFlag, setEditFlag] = useState(false);
  const [editedUser, setEditedUser] = useState({
    nickname: '',
    password: '',
    confirmPassword: ''
  });

  const userInfo = useAppSelector((state) => state.user);
  const { isLoading, error, data } = useQuery({
    queryKey: ['username', userInfo.userId],
    queryFn: () =>
      api(`/members/${userInfo.userId}`, 'get').then(({ data }) => data.data)
  });

  const modifiedUser = useMutation(
    () => {
      if (editedUser.password === editedUser.confirmPassword) {
        return api(`/members/${userInfo.userId}`, 'patch', editedUser).then(
          (res) => console.log(res.data)
        );
      } else {
        throw new Error('Passwords do not match');
      }
    },
    {
      onSuccess: () => {
        const queryClient = useQueryClient();
        queryClient.invalidateQueries(['userInfo']);
      }
    }
  );

  const deleteUser = useMutation(
    () =>
      api(`/members/${userInfo.userId}`, 'delete', {
        userId: userInfo.userId
      }).then((res) => console.log(res.data)),
    {
      onSuccess: () => {
        const queryClient = useQueryClient();
        queryClient.invalidateQueries(['userInfo']);
      }
    }
  );

  const handleEditClick = () => {
    setEditFlag(true);
  };

  const handleReadClick = () => {
    setEditFlag(false);
  };

  const handleFieldChange =
    (fieldName: string) => (event: React.ChangeEvent<HTMLInputElement>) => {
      setEditedUser({
        ...editedUser,
        [fieldName]: event.target.value
      });
    };

  useEffect(() => {
    if (data !== undefined) {
      setEditedUser({
        nickname: data.nickname,
        password: data.password,
        confirmPassword: data.password
      });
    }
  }, [data]);

  return (
    <ThemeProvider theme={defaultTheme}>
      <div style={centerStyle}>
        <Card
          sx={{
            minWidth: 1000,
            borderRadius: '12px',
            boxShadow: (theme) =>
              alpha(theme.palette.primary.light, 0.5) + ` 0px 0.5rem 1.25rem`
          }}
        >
          <CardContent style={{ paddingLeft: '60px', paddingTop: '50px' }}>
            <Typography variant="h5" component="div">
              {editedUser.nickname}
            </Typography>
            <Typography variant="body2">2023년 8월 28일 가입</Typography>
          </CardContent>

          <div
            style={{
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              justifyContent: 'center',
              marginTop: '80px'
            }}
          >
            <div
              style={{
                display: 'flex',
                justifyContent: 'center'
              }}
            >
              <Typography
                variant="h6"
                component="div"
                style={{
                  marginTop: '10px',
                  marginRight: '50px',
                  width: '150px',
                  textAlign: 'left'
                }}
              >
                닉네임
              </Typography>
              <TextField
                required={editFlag}
                id="outlined-read-only-input"
                value={editedUser.nickname}
                onChange={handleFieldChange('nickname')}
                InputProps={{
                  readOnly: !editFlag
                }}
              />
            </div>
            <div style={topMargin} />
            <div
              style={{
                display: 'flex',
                justifyContent: 'center'
              }}
            >
              <Typography
                variant="h6"
                component="div"
                style={{
                  marginTop: '10px',
                  marginRight: '40px',
                  width: '160px',
                  textAlign: 'left'
                }}
              >
                새 비밀번호
              </Typography>
              <TextField
                required={editFlag}
                id="outlined-read-only-input"
                value={editedUser.password}
                onChange={handleFieldChange('password')}
                type="password"
                InputProps={{
                  readOnly: !editFlag
                }}
              />
            </div>
            <div style={topMargin} />
            <div
              style={{
                display: 'flex',
                justifyContent: 'center'
              }}
            >
              <Typography
                variant="h6"
                component="div"
                style={{
                  marginRight: '50px',
                  marginTop: '10px',
                  width: '152px',
                  textAlign: 'left'
                }}
              >
                새 비밀번호 확인
              </Typography>
              <TextField
                required={editFlag}
                id="outlined-read-only-input"
                value={editedUser.confirmPassword}
                onChange={handleFieldChange('confirmPassword')}
                type="password"
                InputProps={{
                  readOnly: !editFlag
                }}
              />
            </div>
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
              {!editFlag && (
                <Button
                  variant="contained"
                  style={{ marginLeft: '8px' }}
                  onClick={handleEditClick}
                >
                  내 정보 수정
                </Button>
              )}
              {editFlag && (
                <Button
                  variant="contained"
                  style={{ marginLeft: '8px' }}
                  onClick={() => {
                    handleReadClick();
                    modifiedUser.mutate();
                  }}
                >
                  수정완료
                </Button>
              )}

              <Button
                variant="contained"
                style={{ marginLeft: '8px' }}
                onClick={() => deleteUser.mutate()}
              >
                계정 삭제
              </Button>
            </div>
          </div>
        </Card>
      </div>
    </ThemeProvider>
  );
}
