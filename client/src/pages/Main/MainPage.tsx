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
import { useQuery } from '@tanstack/react-query';
import api from '../../common/utils/api';

export default function MainPage() {
  const [chapterList, setChapterList] = useState<Chapter[]>([]);
  // const [userChapter, setUserChapter] = useState<UserChapter>();
  const location = useLocation().pathname;
  const dispatch = useAppDispatch();
  const userInfo = useAppSelector((state) => state.user);

  const getChapter = useQuery({
    queryKey: ['getChapterList'],
    queryFn: () => api('/learning', 'get').then(({ data }) => data.data)
  });

  useEffect(() => {
    if (getChapter.isError) {
      alert('Error!');
    }

    if (!getChapter.isLoading) {
      if (!userInfo.memberStatus && !localStorage.getItem('userChapter')) {
        const localUserChapter = {
          chapterList: [{}],
          learningChapterId: 1
        };

        for (let i = 0; i < getChapter.data.length; i++) {
          localUserChapter.chapterList[i] = {
            chapterId: i + 1,
            chapterStatus: false,
            progress: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          };
        }
        localStorage.setItem('userChapter', JSON.stringify(localUserChapter));
      }

      let userChapter: UserChapter = {
        chapterList: [
          {
            chapterId: 1,
            chapterStatus: false,
            progress: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
          }
        ],
        learningChapterId: 1
      };
      const chapterData: Chapter[] = getChapter.data;

      if (userInfo.memberStatus) {
        console.log('get 유저 챕터');
      } else {
        const localUserChapter = localStorage.getItem('userChapter');
        if (localUserChapter !== null) {
          const parseUserChapter = JSON.parse(localUserChapter);

          userChapter = parseUserChapter;
        }
      }

      const changeStatusList = chapterData.map((chapter) => {
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
      console.log(changeStatusList);
      setChapterList(changeStatusList);
      dispatch(setChapter(changeStatusList[0]));
    }
  }, [getChapter.isLoading]);

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
        chapterList={chapterList}
        location={location}
        memberStatus={userInfo.memberStatus}
      />
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
