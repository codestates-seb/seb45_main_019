import { Box, List, ListItemButton, ListItemText, Avatar } from '@mui/material';
import DoneIcon from '@mui/icons-material/Done';
import { grey } from '@mui/material/colors';
import React from 'react';
import { Chapter } from '../../interfaces/Chapter.interface';
interface NavProps {
  chapterList?: Array<Chapter>;
  location: string;
}

export default function Nav(props: NavProps) {
  const chapterList = props.chapterList;
  const location = props.location;

  return (
    <Box
      sx={{
        width: '100%',
        maxWidth: 300,
        height: '100vh',
        borderRight: 1,
        borderColor: grey[300]
      }}
    >
      <List>
        {location === '/'
          ? chapterList?.map((el) => (
              <NavItem key={el.chapterId} chapter={el} />
            ))
          : null}
      </List>
    </Box>
  );
}

interface NavItemProps {
  chapter?: Chapter;
}

function NavItem(props: NavItemProps) {
  const chapter = props.chapter;
  const chapterBigTitle = `Chapter ${chapter ? chapter.chapterId : 0}`;

  console.log(props);
  return (
    <React.Fragment>
      {chapter ? (
        <ListItemButton sx={{ borderBottom: 1, borderColor: grey[200] }}>
          <ListItemText primary={chapterBigTitle} secondary={chapter.title} />
          {chapter.chapterStatus ? (
            <Avatar sx={{ bgcolor: 'success.light' }}>
              <DoneIcon />
            </Avatar>
          ) : null}
        </ListItemButton>
      ) : null}
    </React.Fragment>
  );
}
