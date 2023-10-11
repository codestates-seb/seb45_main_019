import {
  Box,
  Button,
  Container,
  IconButton,
  Stack,
  Typography,
  alpha
} from '@mui/material';
import { Link, useNavigate } from 'react-router-dom';
import CloseRoundedIcon from '@mui/icons-material/CloseRounded';
import QTypeChoice from '../../components/Questions/QTypeChoice';
import QTypeTyping from '../../components/Questions/QTypeTyping';
import { useEffect, useState } from 'react';

import QuestionProgress from '../../components/Progress/QuestionProgress';
import { grey } from '@mui/material/colors';
import { useAppDispatch, useAppSelector } from '../../redux/hooks';
import {
  UserChapter,
  UserChapterListItem
} from '../../interfaces/Chapter.interface';
import useUserChapterQuery, {
  QUERY_KEY as chapterKey
} from '../../queries/useUserChapterQuery';
import {
  localStorageGet,
  localStorageSet
} from '../../common/utils/localStorageFuncs';
import useLearningQuery, {
  QUERY_KEY as learningKey
} from '../../queries/useLearningQuery';
import CheckCircleOutlineRoundedIcon from '@mui/icons-material/CheckCircleOutlineRounded';
import HighlightOffRoundedIcon from '@mui/icons-material/HighlightOffRounded';
import useLearningMutation from '../../queries/useLearningMutation';
import { useQueryClient } from '@tanstack/react-query';
import { setChapter } from '../../redux/slices/chapter';
export default function Questions() {
  const selectedChapter = useAppSelector((state) => state.chapter);
  const userInfo = useAppSelector((state) => state.user);
  const queryClient = useQueryClient();
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
  const dispatch = useAppDispatch();
  const handleLearningExit = () => {
    const conf = confirm('학습을 종료하시겠습니까?');
    if (conf) {
      // 정답 제출하고나서 학습종료 시
      if (correctFlag !== 0) userChapterPatch();

      navigate('/');
    }
  };

  const { data: userChapterData } = useUserChapterQuery(
    userInfo.userId,
    selectedChapter.chapterId
  );

  const { data: learnData } = useLearningQuery(
    selectedChapter.chapterId,
    questionNum
  );

  const { mutate } = useLearningMutation(
    userInfo.userId,
    selectedChapter.chapterId,
    learnData?.questionNum as number
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
    if (userChapter.progress !== undefined) setProgress(userChapter.progress);
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
    setUserInput(e.target.value);
    setCorrectBtnStatus('possible');
    if (e.target.value === '') setCorrectBtnStatus('disabled');
  }

  // 객관식 문제 onClick
  function handleClickUserInput(e: React.MouseEvent<HTMLElement>) {
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
    if (userInput === learnData?.correct) {
      setCorrectFlag(1);
    } else {
      setCorrectFlag(2);
    }

    setCorrectBtnStatus('clicked');
  }

  // 정답 버튼 렌더링
  function correctBtnRender() {
    switch (correctBtnStatus) {
      default:
      case 'possible':
        return (
          <Button
            disabled={correctBtnStatus === 'disabled'}
            onClick={handleCorrect}
            variant="contained"
            style={{
              width: '150px',
              height: '50px',
              fontSize: '1.1em'
            }}
          >
            확인
          </Button>
        );
      case 'clicked':
        return (
          <Button
            onClick={userChapterPatch}
            variant="contained"
            color={correctFlag === 1 ? 'success' : 'error'}
            style={{
              width: '150px',
              height: '50px',
              fontSize: '1.1em',
              marginLeft: 50,
              color: '#fff'
            }}
          >
            {questionNum === 12 ? '결과 보기' : '계속 하기'}
          </Button>
        );
    }
  }

  // 정답 상태 렌더링
  function correctStatusRender() {
    switch (correctFlag) {
      case 1:
        return (
          <Stack flexDirection={'row'} gap={3} alignItems={'center'}>
            <CheckCircleOutlineRoundedIcon
              color="success"
              sx={{ fontSize: 40 }}
            />
            <Typography variant="h4" color="success.main">
              정답입니다!
            </Typography>
          </Stack>
        );
      case 2:
        return (
          <Stack flexDirection={'row'} gap={3} alignItems={'center'}>
            <HighlightOffRoundedIcon color="error" sx={{ fontSize: 40 }} />
            <Typography variant="h4" color="error.main">
              정답 : {learnData?.correct}
            </Typography>
          </Stack>
        );
      default:
        return null;
    }
  }

  // 진행상황 patch
  function userChapterPatch() {
    const userChapter = getUserChapter();
    // 챕터 progress 변경
    const copyProgress = [...userChapter.progress];
    copyProgress[questionNum - 1] = correctFlag;
    userChapter.progress = copyProgress;
    console.log(userChapter);

    let questionPoint = 0;
    if (correctFlag === 1) {
      if (learnData?.questionType === 4) questionPoint = 3;
      else if (learnData?.questionType === 3) questionPoint = 2;
      else questionPoint = 1;
    }

    //마지막 문제일 때 챕터 상태 변경
    if (questionNum === 12) userChapter.chapterStatus = true;

    // 비회원,회원 구분
    if (!userInfo.memberStatus) {
      // 비회원 로컬스토리지 세팅
      const localUserChapter: UserChapter = {
        data: []
      };
      const changeList = localStorageGet().data.map((el) => {
        if (el.chapterId === selectedChapter.chapterId) {
          el.progress = userChapter.progress;
          el.chapterStatus = userChapter.chapterStatus;
        }
        return el;
      });

      localUserChapter.data = changeList;
      localStorageSet(localUserChapter);

      // 쿼리클라이언트 초기화
      queryClient.invalidateQueries([
        learningKey,
        selectedChapter.chapterId,
        learnData?.questionNum
      ]);
      queryClient.invalidateQueries([
        chapterKey,
        userInfo.userId,
        selectedChapter.chapterId
      ]);
    } else {
      // 회원 useMutation
      const dataParam = {
        chapterStatus: userChapter.chapterStatus,
        progress: userChapter.progress,
        point: questionPoint
      };
      const param = {
        memberId: userInfo.userId,
        chapterId: selectedChapter.chapterId,
        questionNum: learnData!.questionNum,
        data: dataParam
      };
      mutate(param);
    }

    // redux 상태변경
    dispatch(
      setChapter({
        title: selectedChapter.title,
        chapterId: selectedChapter.chapterId,
        wordId: selectedChapter.wordId,
        chapterStatus: userChapter.chapterStatus,
        progress: copyProgress
      })
    );

    // 뷰 상태변경
    setCorrectBtnStatus('disabled');
    setCorrectFlag(0);
    setLearningProgress();
    setLearningQuestionNum();
    //마지막 문제일 때 결과페이지로 이동
    if (questionNum === 12) navigate('/learn/result');
  }

  useEffect(() => {
    if (userChapterData !== undefined) {
      setLearningProgress();
      setLearningQuestionNum();
    }
  }, [userChapterData]);

  return (
    <Container
      sx={{
        display: 'flex',
        width: '100%',
        flexDirection: 'column',
        height: '100vh',
        backgroundColor: '#f5f7fa'
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
        <QuestionProgress progress={progress} questionNum={questionNum} />
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
          mt: 15,
          height: '100vh',
          justifyContent: 'flex-start',
          alignItems: 'center'
        }}
      >
        {handleQTypeRender()}
      </Container>
      <Box
        sx={{
          width: '100%',
          padding: '50px',
          display: 'flex',
          justifyContent: 'center',
          alignItems: 'center',
          backgroundColor:
            correctFlag === 0
              ? grey[200]
              : correctFlag === 1
              ? (theme) => alpha(theme.palette.success.main, 0.25)
              : (theme) => alpha(theme.palette.error.main, 0.25)
        }}
      >
        {correctStatusRender()}
        {correctBtnRender()}
      </Box>
    </Container>
  );
}
