import React, { useEffect, useState } from 'react';
import Enter from '../../components/Enter/Enter';
import Nav from '../../components/Nav/Nav';
// import { chapterData, userChapterAllData } from '../../common/data/chapterData';
import { Chapter, UserChapter } from '../../interfaces/Chapter.interface';
import { useLocation } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from '../../redux/hooks';
import { setChapter } from '../../redux/slices/chapter';
import Header from '../../components/Header/Header';
import { Box } from '@mui/material';
import useAllChapterQuery from '../../quries/useAllChapterQuery';

export default function MainPage() {
  const [chapterList, setChapterList] = useState<Chapter[]>([]);
  const location = useLocation().pathname;
  const dispatch = useAppDispatch();
  const userInfo = useAppSelector((state) => state.user);
  const selectedChapter = useAppSelector((state) => state.chapter);

  const { data: allChapterList } = useAllChapterQuery();

  //onError callback
  //default config
  //error code
  //loading, error page - 404(페이지 잔존 여부)

  //1. 로컬/서버 분리
  //2. token으로 구분

  useEffect(() => {
    // data가 들어왔을때 실행
    if (allChapterList !== undefined) {
      let userChapter: UserChapter = {
        chapterList: [
          {
            chapterId: 1,
            chapterStatus: false,
            progress: [0]
          }
        ],
        learningChapterId: 1
      };

      // 비회원 접속 시 userChapter 세팅
      if (!userInfo.memberStatus) {
        // 로컬스토리지 정보가 없을 시 초기 세팅
        if (!localStorage.getItem('userChapter')) {
          const localUserChapter = {
            chapterList: [{}],
            learningChapterId: 1
          };

          for (let i = 0; i < allChapterList.data.length; i++) {
            localUserChapter.chapterList[i] = {
              chapterId: i + 1,
              chapterStatus: false,
              progress: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
            };
          }
          localStorage.setItem('userChapter', JSON.stringify(localUserChapter));
        }
        // 로컬스토리지 정보가 있을 시 가져와서 진행
        const localUserChapter = localStorage.getItem('userChapter');
        if (localUserChapter !== null) {
          const parseUserChapter = JSON.parse(localUserChapter);

          userChapter = parseUserChapter;
        }
      } else {
        // 유저 로그인 시 userChapter 세팅
        console.log('get 유저 챕터');
      }

      // 챕터 데이터랑 유저 챕터 정보랑 mapping
      const changeStatusList = allChapterList.data.map((chapter) => {
        const sameChapter = userChapter?.chapterList.find(
          (userChapter) => userChapter.chapterId === chapter.chapterId
        );

        if (sameChapter?.chapterStatus) {
          return {
            ...chapter,
            chapterStatus: true,
            learningChapterId: userChapter.learningChapterId,
            progress: sameChapter?.progress
          };
        } else {
          return {
            ...chapter,
            chapterStatus: false,
            learningChapterId: userChapter.learningChapterId,
            progress: sameChapter?.progress
          };
        }
      });
      // 변경된 챕터리스트로 setState
      setChapterList(changeStatusList);

      // 첫 접속시 Enter, Nav 첫 챕터로 세팅
      if (selectedChapter.chapterId === 0) {
        dispatch(setChapter(changeStatusList[0]));
      }
    }
  }, [allChapterList]);

  return (
    <Box
      sx={{
        display: 'flex',
        width: '100%',
        minHeight: 'calc(100vh - 70px)',
        backgroundColor: '#f5f7fa'
      }}
    >
      <Nav chapterList={chapterList} location={location} />
      <Box
        sx={{
          width: 'calc(100% - 270px)',
          marginLeft: '270px'
        }}
      >
        <Header invisiblePath={true} />
        <Enter />
      </Box>
    </Box>
  );
}
