import React, { useEffect, useState } from 'react';
import Box from '@mui/material/Box';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import api from '../../common/utils/api';
import { alpha } from '@mui/material/styles';
import TextField from '@mui/material/TextField';
import { AxiosError } from 'axios';
import Dialog from '@mui/material/Dialog';
import DialogTitle from '@mui/material/DialogTitle';
import DialogContent from '@mui/material/DialogContent';
import DialogActions from '@mui/material/DialogActions';
import { useAppSelector } from '../../redux/hooks';
import { GlobalContainer } from '../../style/Global.styled';
import { Container } from '@mui/material';
import RecordChart from '../../components/Record/RecordChart';

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

  const [isDeleteUserModal, setIsDeleteUserModal] = useState(false);
  const [isSuccessModalOpen, setIsSuccessModalOpen] = useState(false);
  const userInfo = useAppSelector((state) => state.user);
  const queryClient = useQueryClient();
  const { isLoading, error, data } = useQuery({
    queryKey: ['username', userInfo.userId],
    queryFn: () =>
      api(`/members/${userInfo.userId}`, 'get').then(({ data }) => data.data)
  });

  const modifiedUserMutation = useMutation(
    (newUserData: {
      nickname: string;
      password: string;
      confirmPassword: string;
    }) => {
      if (newUserData.password === newUserData.confirmPassword) {
        return api(`/members/${userInfo.userId}`, 'patch', newUserData).then(
          (res) => res.data
        );
      } else {
        throw new Error('Passwords do not match');
      }
    },
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['username', userInfo.userId]);
        openSuccessModal();
      }
    }
  );

  const deleteUserMutation = useMutation(
    () =>
      api(`/members/${userInfo.userId}`, 'delete', {
        userId: userInfo.userId
      }).then((res) => res.data),
    {
      onSuccess: () => {
        queryClient.invalidateQueries(['username', userInfo.userId]);
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

  const handleModifiedUser = () => {
    modifiedUserMutation.mutate(editedUser);
  };

  const handleDeleteClick = () => {
    setIsDeleteUserModal(true);
  };

  const handleConfirmDelete = () => {
    deleteUserMutation.mutate();
    setIsDeleteUserModal(false);
  };

  const handleCancelDelete = () => {
    setIsDeleteUserModal(false);
  };

  const openSuccessModal = () => {
    setIsSuccessModalOpen(true);
  };

  const closeSuccessModal = () => {
    setIsSuccessModalOpen(false);
  };

  return (
    <GlobalContainer>
      <Container
        sx={{
          display: 'flex',
          minHeight: 'calc(100vh - 70px)',
          justifyContent: 'center',
          alignItems: 'center'
        }}
      >
        <Card
          sx={{
            minWidth: 1000,
            borderRadius: '12px',
            boxShadow: (theme) =>
              alpha(theme.palette.primary.light, 0.5) + ` 0px 0.5rem 1.25rem`
          }}
        >
          <CardContent style={{ paddingLeft: '60px', paddingTop: '50px' }}>
            <Typography
              variant="h2"
              component="div"
              style={{ marginBottom: '20px' }}
            >
              {editedUser.nickname}
            </Typography>
            <Typography variant="body1">2023년 8월 28일 가입</Typography>
          </CardContent>

          <RecordChart />

          <div
            style={{
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
              justifyContent: 'center',
              marginTop: '60px'
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
                value={editedUser.password || ''}
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
                value={editedUser.confirmPassword || ''}
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
              marginTop: '60px'
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
                    handleModifiedUser();
                  }}
                >
                  수정완료
                </Button>
              )}

              <Button
                variant="contained"
                style={{ marginLeft: '8px' }}
                onClick={() => {
                  handleDeleteClick();
                  deleteUserMutation.mutate();
                }}
              >
                계정 삭제
              </Button>
            </div>
          </div>
        </Card>
      </Container>
      <Dialog open={isDeleteUserModal} onClose={handleCancelDelete}>
        <DialogTitle>계정 삭제</DialogTitle>
        <DialogContent>
          <Typography>정말로 계정을 삭제하시겠습니까?</Typography>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleCancelDelete}>취소</Button>
          <Button onClick={handleConfirmDelete}>확인</Button>
        </DialogActions>
      </Dialog>

      <Dialog open={isSuccessModalOpen} onClose={closeSuccessModal}>
        <DialogTitle>수정 완료</DialogTitle>
        <DialogContent>
          <Typography>수정이 완료되었습니다</Typography>
        </DialogContent>
        <DialogActions>
          <Button onClick={closeSuccessModal}>확인</Button>
        </DialogActions>
      </Dialog>
    </GlobalContainer>
  );
}
