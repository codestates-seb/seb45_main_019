import React, { useEffect, useState } from 'react';
import Enter from '../../components/Enter/Enter';
import Nav from '../../components/Nav/Nav';
import { chapterData, userChapterData } from '../../common/data/chapterData';
import { Chapter, UserChapter } from '../../interfaces/Chapter.interface';
import { useLocation } from 'react-router-dom';
import { useAppDispatch } from '../../redux/hooks';
import { setChapter } from '../../redux/slices/chapter';
export default function MainPage() {
  const [chapterList, setChapterList] = useState<Chapter[]>([]);
  // const [userChapter, setUserChapter] = useState<UserChapter>();
  const location = useLocation().pathname;
  const dispatch = useAppDispatch();

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
          learningChapterId: userChapterData.learningChapterId,
          progress: sameChapter?.progress
        };
      } else {
        return {
          ...chapter,
          chapterStatus: false,
          learningChapterId: userChapterData.learningChapterId,
          progress: sameChapter?.progress
        };
      }
    });
    setChapterList(changeStatusList);
    dispatch(setChapter(changeStatusList[0]));
    // setUserChapter(userChapterData);

    // TODO: 회원정보가 없는 유저일 경우
    // localStorage Get Set
  }, []);

  return (
    <React.Fragment>
      <Nav chapterList={chapterList} location={location} />
      <Enter />
    </React.Fragment>
  );
}
