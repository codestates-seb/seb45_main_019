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
import AlertDialog from '../../components/Dialogs/AlertDialog';

export default function WordPage() {
  //const [open, setOpen] = useState(false); //추가
  const user = useAppSelector((state) => state.user);
  const navigate = useNavigate();
  const [selectedWordId, setSelectedWordId] = useState(0);
  const wordIds = getUserWordIds();
  /*
  const handleOpen = () => {
    setOpen(true);
  };
  const handleClose = () => {
    setOpen(false);
  };
*/
  const [loginDialogOpen, setloginDialogOpen] = useState(false);
  useEffect(() => {
    if (!user.memberStatus) {
      setloginDialogOpen(true);
    }
  }, []);

  const [emptyDialogOpen, setEmptyDialogOpen] = useState(false);
  useEffect(() => {
    if (wordIds) {
      if (wordIds.length === 0) {
        setEmptyDialogOpen(true);
      } else setSelectedWordId(wordIds[0]);
    }
  }, [wordIds]);

  return (
    <Box
      sx={{
        display: 'flex',
        width: '100%',
        minHeight: 'calc(100vh - 70px)',
        backgroundColor: '#f5f7fa'
      }}
    >
      <AlertDialog
        open={loginDialogOpen}
        setOpen={setloginDialogOpen}
        title="단어장 기능"
        content="회원만 이용이 가능합니다."
        onConfirm={() => navigate('/signin')}
      ></AlertDialog>
      <AlertDialog
        open={emptyDialogOpen}
        setOpen={setEmptyDialogOpen}
        title="단어장 기능"
        content="단어장이 비었습니다."
        onConfirm={() => navigate('/')}
      ></AlertDialog>
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
