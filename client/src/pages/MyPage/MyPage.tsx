import React, { useState } from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import Input from '../../pages/SignUp/Input';
import api from '../../common/utils/api';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import { alpha, createTheme, ThemeProvider } from '@mui/material/styles';

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
  const [isEditing, setIsEditing] = useState(false); // 추가: 수정 모드 여부를 나타내는 상태 변수

  const nickname = 'Einstein';
  const username = 'einstein12';
  const email = 'einstein12@nnnnn.com';

  // 각 필드의 상태 변수 추가
  const [editedNickname, setEditedNickname] = useState(nickname);
  const [editedUsername, setEditedUsername] = useState(username);
  const [editedEmail, setEditedEmail] = useState(email);

  // 필드를 수정 모드로 전환하는 함수
  const handleEditClick = () => {
    setIsEditing(true);
  };

  // 수정을 완료하고 필드를 읽기 전용 모드로 전환하는 함수
  const handleSaveClick = () => {
    setIsEditing(false);
  };

  // 각 필드의 값을 수정하는 함수
  const handleNicknameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEditedNickname(event.target.value);
  };

  const handleUsernameChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEditedUsername(event.target.value);
  };

  const handleEmailChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setEditedEmail(event.target.value);
  };

  return (
    <ThemeProvider theme={defaultTheme}>
      <div style={centerStyle}>
        <Card sx={{ minWidth: 1000 }}>
          <CardContent style={{ paddingLeft: '60px', paddingTop: '50px' }}>
            <Typography variant="h5" component="div">
              Einstein
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
              required={isEditing}
              id="outlined-read-only-input"
              value={editedNickname} // 수정된 값 사용
              onChange={handleNicknameChange} // 값 변경 핸들러
              InputProps={{
                readOnly: !isEditing
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
              required={isEditing}
              id="outlined-read-only-input"
              value={editedUsername} // 수정된 값 사용
              onChange={handleUsernameChange} // 값 변경 핸들러
              InputProps={{
                readOnly: !isEditing
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
              required={isEditing}
              id="outlined-read-only-input"
              value={editedEmail} // 수정된 값 사용
              onChange={handleEmailChange} // 값 변경 핸들러
              InputProps={{
                readOnly: !isEditing
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
              {!isEditing && (
                <Button
                  variant="outlined"
                  style={{ marginLeft: '8px' }}
                  onClick={handleEditClick}
                >
                  내 정보 수정
                </Button>
              )}
              {isEditing && (
                <Button
                  variant="outlined"
                  style={{ marginLeft: '8px' }}
                  onClick={handleSaveClick}
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
