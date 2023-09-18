import { Box } from '@mui/material';
import { useAppSelector } from '../../redux/hooks';
import { useNavigate } from 'react-router';
import { useEffect, useState } from 'react';
import Header from '../../components/Header/Header';
import Nav from './Nav';
import { getUserWordIds, getWordSub, getWordWord } from './methods';
import Word from '../../components/Word/Word';
import { number } from 'yargs';

export default function WordPage() {
  const user = useAppSelector((state) => state.user);
  const navigate = useNavigate();
  const [selectedWordId, setSelectedWordId] = useState(0);
  const wordIds = getUserWordIds();

  console.log(wordIds);

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
