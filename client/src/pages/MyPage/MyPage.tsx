import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
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
  const [editFlag, setEditFlag] = useState(false);
  const [editedUser, setEditedUser] = useState({
    nickname: '',
    username: '',
    email: ''
  });

  const userInfo = useAppSelector((state) => state.user);
  const { isLoading, error, data } = useQuery({
    queryKey: ['username', userInfo.userId],
    queryFn: () =>
      api(`/members/${userInfo.userId}`, 'get').then(({ data }) => data.data)
  });
  /*
    const addToMyWords = useMutation(
    () =>
      api(`/words/members/${user.userId}`, 'post', {
        wordId: props.wordId
      }).then(({ data }) => {
        console.log(data);
      }),
    {
      onSuccess: () => queryClient.invalidateQueries(['userWordIds'])
    }
  );
*/
  const modifiedUser = useMutation(
    () =>
      api(`/members/${userInfo.userId}`, 'patch', {
        userId: userInfo.userId
      }).then((res) => console.log(res.data)),
    {
      onSuccess: () => {
        const queryClient = useQueryClient();
        queryClient.invalidateQueries(['userWordsIds']);
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
        queryClient.invalidateQueries(['userWordsIds']);
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
        username: data.username,
        email: data.email
      });
    }
  }, [data]);

  return (
    <ThemeProvider theme={defaultTheme}>
      <div style={centerStyle}>
        <Card sx={{ minWidth: 1000 }}>
          <CardContent style={{ paddingLeft: '60px', paddingTop: '50px' }}>
            <Typography variant="h5" component="div">
              {editedUser.username}
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
              required={editFlag}
              id="outlined-read-only-input"
              value={editedUser.nickname}
              onChange={handleFieldChange('nickname')}
              InputProps={{
                readOnly: !editFlag
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
              required={editFlag}
              id="outlined-read-only-input"
              value={editedUser.username}
              onChange={handleFieldChange('username')}
              InputProps={{
                readOnly: !editFlag
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
              required={editFlag}
              id="outlined-read-only-input"
              value={editedUser.email}
              onChange={handleFieldChange('email')}
              InputProps={{
                readOnly: !editFlag
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
              {!editFlag && (
                <Button
                  variant="outlined"
                  style={{ marginLeft: '8px' }}
                  onClick={handleEditClick}
                >
                  내 정보 수정
                </Button>
              )}
              {editFlag && (
                <Button
                  variant="outlined"
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
                variant="outlined"
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
