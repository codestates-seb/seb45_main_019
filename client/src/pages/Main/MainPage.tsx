import { useEffect, useState } from 'react';
import Enter from '../../components/Enter/Enter';
import Nav from '../../components/Nav/Nav';
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
  const { data: allUserChapterList } = useAllUserChapterQuery(userInfo.userId);

  function getUserChapters(): UserChapter {
    if (!userInfo.memberStatus) {
      localStorageInit(allChapterList as ChapterList);
      return localStorageGet();
    } else {
      return allUserChapterList as UserChapter;
    }
  }

  function setUserChapters(): void {
    const userChapter = getUserChapters();
    const changeStatusList = allChapterList!.data.map((chapter) => {
      const sameChapter = userChapter?.data.find(
        (userChapter) => userChapter.chapterId === chapter.chapterId
      );

      if (sameChapter?.chapterStatus) {
        return {
          ...chapter,
          chapterStatus: true,
          progress: sameChapter.progress!
        };
      } else {
        return {
          ...chapter,
          chapterStatus: false,
          progress: sameChapter?.progress
        };
      }
    });

    setChapterList(changeStatusList);

    dispatch(setChapter(changeStatusList[selectedChapter.chapterId - 1]));
  }

  useEffect(() => {
    if (allChapterList !== undefined && allUserChapterList !== undefined) {
      setUserChapters();
    }
  }, [allChapterList, allUserChapterList]);
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
