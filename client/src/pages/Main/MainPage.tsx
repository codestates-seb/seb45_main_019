import React, { useEffect, useState } from 'react';
import Enter from '../../components/Enter/Enter';
import Nav from '../../components/Nav/Nav';
import { chapterData, userChapterData } from '../../common/data/chapterData';
import { Chapter, UserChapter } from '../../interfaces/Chapter.interface';
import { useLocation } from 'react-router-dom';
export default function MainPage() {
  const [chapterList, setChapterList] = useState<Chapter[]>([]);
  const [userChapter, setUserChapter] = useState<UserChapter>();
  const location = useLocation().pathname;

  useEffect(() => {
    // 회원정보가 있는 유저일 경우
    // 챕터 완료 상태 변경
    const changeStatusList = chapterData.map((chapter) => {
      const sameChapter = userChapterData?.chapterList.find(
        (userChapter) => userChapter.chapterId === chapter.chapterId
      );

      if (sameChapter?.chapterStatus) {
        return {
          ...chapter,
          chapterStatus: true,
          learningChapterId: userChapterData.learningChapterId
        };
      } else {
        return {
          ...chapter,
          chapterStatus: false,
          learningChapterId: userChapterData.learningChapterId
        };
      }
    });
    setChapterList(changeStatusList);
    setUserChapter(userChapterData);

    // TODO: 회원정보가 없는 유저일 경우
    // localStorage Get Set
  }, []);

  // useEffect(() => {
  //   setUserChapter(userChapterData);

  //   // 챕터 완료 상태 변경
  //   const changeStatusList = chapterList.map((chapter) => {
  //     const sameChapter = userChapter?.chapterList.find(
  //       (userChapter) => userChapter.chapterId === chapter.chapterId
  //     );

  //     if (sameChapter?.chapterStatus) {
  //       return (chapter.chapterStatus = true);
  //     } else {
  //       return (chapter.chapterStatus = false);
  //     }
  //   });
  //   // setChapterList(changeStatusList);
  //   // console.log(changeStatusList);
  // }, [isLoggedIn]);

  return (
    <React.Fragment>
      <Nav chapterList={chapterList} location={location} />
      <Enter />
    </React.Fragment>
  );
}
