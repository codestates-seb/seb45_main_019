import React, { useEffect, useState } from 'react';
import Enter from '../../components/Enter/Enter';
import Nav from '../../components/Nav/Nav';
// import { chapterData, userChapterAllData } from '../../common/data/chapterData';
import {
  Chapter,
  ChapterList,
  UserChapter
} from '../../interfaces/Chapter.interface';
import { useLocation } from 'react-router-dom';
import { useAppDispatch, useAppSelector } from '../../redux/hooks';
import { setChapter } from '../../redux/slices/chapter';
import Header from '../../components/Header/Header';
import { Box } from '@mui/material';
import useAllChapterQuery from '../../queries/useAllChapterQuery';
import useAllUserChapterQuery from '../../queries/useAllUserChapterQuery';
import {
  localStorageGet,
  localStorageInit
} from '../../common/utils/localStorageFuncs';

export default function MainPage() {
  const [chapterList, setChapterList] = useState<Chapter[]>([]);
  const { pathname: location } = useLocation();
  const dispatch = useAppDispatch();
  const userInfo = useAppSelector((state) => state.user);
  const selectedChapter = useAppSelector((state) => state.chapter);

  const { data: allChapterList } = useAllChapterQuery();
  const { data: allUserChapterList } = useAllUserChapterQuery(1);

  //onError callback
  //default config
  //error code
  //loading, error page - 404(페이지 잔존 여부)

  //1. 로컬/서버 분리
  //2. token으로 구분

  function getUserChapter(): UserChapter {
    if (!userInfo.memberStatus) {
      localStorageInit(allChapterList as ChapterList);
      return localStorageGet();
    } else {
      return allUserChapterList as UserChapter;
    }
  }

  // data가 들어왔을때 실행
  if (allChapterList !== undefined && allUserChapterList !== undefined) {
    const userChapter = getUserChapter();

    const changeStatusList = allChapterList.data.map((chapter) => {
      const sameChapter = userChapter?.chapterList.find(
        (userChapter) => userChapter.chapterId === chapter.chapterId
      );

      if (sameChapter?.chapterStatus) {
        return {
          ...chapter,
          chapterStatus: true,
          progress: sameChapter?.progress
        };
      } else {
        return {
          ...chapter,
          chapterStatus: false,
          progress: sameChapter?.progress
        };
      }
    });

    if (changeStatusList.length === 19) {
      setChapterList(changeStatusList);
    }

    console.log(changeStatusList);

    // 첫 접속시 Enter, Nav 첫 챕터로 세팅
    if (selectedChapter.chapterId === 0) {
      dispatch(setChapter(changeStatusList[0]));
    }

    // setChapterList(changeStatusList);
    // let userChapter: UserChapter = {
    //   chapterList: [
    //     {
    //       chapterId: 1,
    //       chapterStatus: false,
    //       progress: [0]
    //     }
    //   ]
    // };

    // 챕터 데이터랑 유저 챕터 정보랑 mapping
    // const changeStatusList = allChapterList!.data.map((chapter) => {
    //   const sameChapter = userChapter?.chapterList.find(
    //     (userChapter) => userChapter.chapterId === chapter.chapterId
    //   );

    //   if (sameChapter?.chapterStatus) {
    //     return {
    //       ...chapter,
    //       chapterStatus: true,
    //       progress: sameChapter?.progress
    //     };
    //   } else {
    //     return {
    //       ...chapter,
    //       chapterStatus: false,
    //       progress: sameChapter?.progress
    //     };
    //   }
    // });
    // // 변경된 챕터리스트로 setState
    // setChapterList(changeStatusList);

    // // 첫 접속시 Enter, Nav 첫 챕터로 세팅
    // if (selectedChapter.chapterId === 0) {
    //   dispatch(setChapter(changeStatusList[0]));
    // }
  }

  useEffect(() => {
    console.log('effect');
  }, []);

  return (
    <Box
      sx={{
        display: 'flex',
        width: '100%',
        minHeight: 'calc(100vh - 70px)',
        backgroundColor: '#f5f7fa'
      }}
    >
      {/* <Nav chapterList={chapterList} location={location} /> */}
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
