import { Box } from '@mui/material';
import { useAppSelector } from '../../redux/hooks';
import { useNavigate } from 'react-router';
import { useEffect, useState } from 'react';
import Header from '../../components/Header/Header';
import Nav from './Nav';
import { getUserWordIds, getWordSub, getWordWord } from './methods';
import Word from '../../components/Word/Word';
import { number } from 'yargs';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';

export default function WordPage() {
  //const [open, setOpen] = useState(false); //추가
  const user = useAppSelector((state) => state.user);
  const navigate = useNavigate();
  const [selectedWordId, setSelectedWordId] = useState(0);
  const wordIds = getUserWordIds();

  console.log(wordIds);
  /*
  const handleOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
  };
*/
  useEffect(() => {
    console.log(user);
    if (!user.memberStatus) {
      alert('로그인 후 이용해 주세요.');
      navigate('/signin');
    }
  }, []);

  useEffect(() => {
    if (wordIds) {
      setSelectedWordId(wordIds[0]);
    }
  }, [wordIds]);

  if (!wordIds) {
    alert('단어장을 불러올 수 없습니다.');
    return <Header />;
  }

  /*
  useEffect(() => {
    if (!wordIds) {
      return (
        <Dialog open={open} onClose={handleClose}>
          <DialogTitle id="alert-dialog-title">
            {'단어장을 찾을 수 없습니다.'}
          </DialogTitle>
          <DialogContent>
            <DialogContentText id="alert-dialog-description">
              단어가 없습니다!
            </DialogContentText>
          </DialogContent>
          <DialogActions>
            <Button variant="contained" onClick={handleClose}>
              닫기
            </Button>
          </DialogActions>
        </Dialog>
      );
      navigate('/');
    }
  }, []);
*/
  return (
    <Box
      sx={{
        display: 'flex',
        width: '100%',
        minHeight: 'calc(100vh - 70px)',
        backgroundColor: '#f5f7fa'
      }}
    >
      <Nav
        ids={wordIds}
        args={{
          selectedId: selectedWordId,
          setSelectedId: setSelectedWordId,
          getTitle: getWordWord,
          getSubTitle: getWordSub
        }}
      />
      <Box
        sx={{
          width: 'calc(100% - 270px)',
          marginLeft: '270px'
        }}
      >
        <Header invisiblePath={true} />
        <Box
          sx={{
            display: 'flex',
            alignItems: 'center',
            justifyContent: 'center',
            mt: 10
          }}
        >
          {wordIds.length > 0 && selectedWordId !== 0 && (
            <Word wordId={selectedWordId}></Word>
          )}
        </Box>
      </Box>
    </Box>
  );
}
