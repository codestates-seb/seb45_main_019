import { Chapter } from '../../interfaces/Chapter.interface';
import DoneIcon from '@mui/icons-material/Done';
import { grey } from '@mui/material/colors';
import { ListItemButton, ListItemText, Avatar } from '@mui/material';
import React from 'react';
import { useAppSelector, useAppDispatch } from '../../redux/hooks';
import { setChapter } from '../../redux/slices/chapter';

interface NavItemProps {
  chapter?: Chapter;
}

export default function NavItem(props: NavItemProps) {
  const chapter = props.chapter;
  const chapterBigTitle = `Chapter ${chapter ? chapter.chapterId : 0}`;
  const selectedChapter = useAppSelector((state) => state.chapter);
  const dispatch = useAppDispatch();

  const handleSelectChapter = () => {
    dispatch(setChapter(chapter!));
  };
  return (
    <React.Fragment>
      {chapter ? (
        <ListItemButton
          onClick={handleSelectChapter}
          sx={{
            borderBottom: 1,
            borderBottomColor: grey[200],
            borderLeft: 8,
            borderLeftColor:
              chapter.chapterId === selectedChapter.chapterId
                ? 'primary.main'
                : '#1976d200'
          }}
        >
          <ListItemText primary={chapterBigTitle} secondary={chapter.title} />
          {chapter.chapterStatus ? (
            <Avatar sx={{ bgcolor: 'success.main' }}>
              <DoneIcon />
            </Avatar>
          ) : null}
        </ListItemButton>
      ) : null}
    </React.Fragment>
  );
}
