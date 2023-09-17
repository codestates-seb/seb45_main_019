import { Box, Button, Container, IconButton, Stack } from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import QTypeChoice from '../../components/Questions/QTypeChoice';
import QTypeTyping from '../../components/Questions/QTypeTyping';
import { useEffect, useState } from 'react';

import QuestionProgress from '../../components/Progress/QuestionProgress';
import { grey } from '@mui/material/colors';
import { useAppSelector } from '../../redux/hooks';
import {
  UserChapter,
  UserChapterListItem
} from '../../interfaces/Chapter.interface';
import useUserChapterQuery from '../../queries/useUserChapterQuery';
import { localStorageGet } from '../../common/utils/localStorageFuncs';
import useLearningQuery from '../../queries/useLearningQuery';
import { Learning } from '../../interfaces/Learning.interface';
import { setUser } from '../../redux/slices/user';
export default function Questions() {
  const selectedChapter = useAppSelector((state) => state.chapter);
  const userInfo = useAppSelector((state) => state.user);

  // const [question, setQuestion] = useState<Learning>({} as Learning);
  const [progress, setProgress] = useState<(0 | 1 | 2)[]>([]);
  const [questionNum, setQuestionNum] = useState<number>(1);
  const [userInput, setUserInput] = useState<string>('');
  // disabled : 디폴트, possible : userInput 들어왔을때 클릭 가능, clicked : 다음 문제 넘어가기
  const [correctBtnStatus, setCorrectBtnStatus] = useState<
    'disabled' | 'possible' | 'clicked'
  >('disabled');
  // 0 : 디폴트, 1 : 정답, 2 : 오답
  const [correctFlag, setCorrectFlag] = useState<0 | 1 | 2>(0);
  const navigate = useNavigate();

  const handleLearningExit = () => {
    const conf = confirm('학습을 종료하시겠습니까?');
    if (conf) {
      navigate('/');
    }
  };

  const { data: userChapterData } = useUserChapterQuery(
    userInfo.userId,
    selectedChapter.chapterId
  );

  // typing 테스트 목적으로 3으로 요청
  const { data: learnData } = useLearningQuery(
    selectedChapter.chapterId,
    3
    // questionNum
  );

  // 챕터 진행상황 가져오기
  function getUserChapter(): UserChapterListItem {
    if (!userInfo.memberStatus) {
      const localUserChapter = localStorageGet().data.find((el) => {
        return el.chapterId === selectedChapter.chapterId;
      });
      return localUserChapter as UserChapterListItem;
    } else {
      return userChapterData as UserChapterListItem;
    }
  }

  // 프로그레스 세팅
  function setLearningProgress(): void {
    const userChapter = getUserChapter();
    setProgress(userChapter.progress);
  }

  // 문제 번호 세팅
  function setLearningQuestionNum(): void {
    const userChapter = getUserChapter();
    const learnQuestionNum = userChapter.progress.findIndex((el) => el === 0);
    if (0 < learnQuestionNum) {
      setQuestionNum(learnQuestionNum + 1);
    }
  }

  // 주관식 문제 onChange
  function handleChangeUserInput(e: React.ChangeEvent<HTMLInputElement>) {
    console.log(e.target.value);
    setUserInput(e.target.value);
    setCorrectBtnStatus('possible');
  }

  // 객관식 문제 onClick
  function handleClickUserInput(e: React.MouseEvent<HTMLElement>) {
    console.log(e.currentTarget.innerText);
    setUserInput(e.currentTarget.innerText);
    setCorrectBtnStatus('possible');
  }

  // 문제 타입 별 렌더링
  function handleQTypeRender() {
    if (learnData !== undefined) {
      if (learnData?.questionType === 3) {
        return (
          <QTypeTyping
            question={learnData}
            handleChangeUserInput={handleChangeUserInput}
            status={correctBtnStatus}
          />
        );
      } else {
        return (
          <QTypeChoice
            question={learnData}
            handleClickUserInput={handleClickUserInput}
            status={correctBtnStatus}
          />
        );
      }
    }
    return;
  }

  // 정답 확인
  function handleCorrect() {
    console.log(learnData?.correct);
    console.log(userInput);
    if (userInput === learnData?.correct) setCorrectFlag(1);
    else setCorrectFlag(2);

    setCorrectBtnStatus('clicked');
  }

  // 정답 버튼 렌더링
  function correctBtnRender() {
    switch (correctBtnStatus) {
      case 'possible':
        return <Button onClick={handleCorrect}>확인</Button>;
      case 'clicked':
        return <Button>계속 하기</Button>;
      default:
        return <Button disabled>확인</Button>;
    }
  }

  // 정답 상태 렌더링
  function correctStatusRender() {
    switch (correctFlag) {
      case 1:
        return (
          <Box>
            정답
            {correctBtnRender()}
          </Box>
        );
      case 2:
        return (
          <Box>
            오답
            {learnData?.correct}
            {correctBtnRender()}
          </Box>
        );
      default:
        return <Box>{correctBtnRender()}</Box>;
    }
  }

  // 진행상황 patch
  function userChapterPatch() {}

  useEffect(() => {
    if (userChapterData !== undefined && learnData !== undefined) {
      setLearningProgress();
      setLearningQuestionNum();
      // setQuestion(learnData);
    }
  }, [userChapterData]);

  return (
    <Container
      sx={{
        display: 'flex',
        width: '100%',
        flexDirection: 'column',
        height: '100vh'
      }}
      maxWidth={false}
      disableGutters
    >
      <Box
        sx={{
          width: '100%',
          textAlign: 'right',
          padding: '20px',
          position: 'relative'
        }}
      >
        <QuestionProgress progress={progress} />
        <IconButton
          aria-label="delete"
          size="large"
          onClick={handleLearningExit}
        >
          <CloseRoundedIcon fontSize={'large'} />
        </IconButton>
      </Box>
      <Container
        sx={{
          display: 'flex',
          width: '100%',
          flexDirection: 'column',
          marginTop: '30px',
          height: '100vh'
        }}
      >
        {handleQTypeRender()}
      </Container>
      <Box sx={{ width: '100%', padding: '20px' }} bgcolor={grey[200]}>
        {correctStatusRender()}
      </Box>
    </Container>
  );
}
