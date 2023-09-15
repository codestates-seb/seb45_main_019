import { Box, List } from '@mui/material';
import {
  Chapter,
  ChapterList,
  UserChapter
} from '../../interfaces/Chapter.interface';
import { Link } from 'react-router-dom';
import MainNavItem from './MainNavItem';

interface NavProps {
  // chapterList?: Chapter[];
  chapterList: ChapterList;
  userChapterData: UserChapter;
  location: string;
  myWordList?: number[]; // TODO: Word 인터페이스 추가
}

export default function Nav(props: NavProps) {
  const chapterList = props.chapterList;
  const location = props.location;
  const myWordList = props.myWordList;
  const userChapterData = props.userChapterData;

  console.log(chapterList);
  console.log(userChapterData);

  // function handleNavPage() {
  //   if (location === '/') {
  //     return chapterList?.map((el) => (
  //       <MainNavItem key={el.chapterId} chapter={el} />
  //     ));
  //   } else if (location === '/my-word') {
  //     // WordNavItem.tsx 렌더링
  //     return myWordList;
  //   } else {
  //     return null;
  //   }
  // }

  return (
    <Box
      sx={{
        width: '100%',
        maxWidth: 270,
        padding: 0,
        backgroundColor: '#fff',
        position: 'fixed',

        zIndex: 10
      }}
    >
      <Box
        sx={{
          paddingLeft: '24px',
          height: '70px',
          display: 'flex',
          alignItems: 'center'
        }}
      >
        <Link to="/">
          <img src="./images/main-logo.png" alt="Main Logo" />
        </Link>
      </Box>
      <List
        sx={{
          overflowY: 'auto',
          height: 'calc(100vh - 70px)',
          padding: 0,
          '&::-webkit-scrollbar': {
            width: '0.4em',
            backgroundColor: 'rgba(0,0,0,.0)'
          },
          '&::-webkit-scrollbar-track': {
            boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)',
            webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)'
          },
          '&:hover::-webkit-scrollbar-thumb': {
            transition: 'all 1s ease',
            backgroundColor: 'rgba(0,0,0,.2)'
          },
          '&::-webkit-scrollbar-thumb': {
            borderRadius: '20px',
            backgroundColor: 'rgba(0,0,0,.0)'
          }
        }}
      >
        {/* {handleNavPage()} */}
      </List>
    </Box>
  );
}
