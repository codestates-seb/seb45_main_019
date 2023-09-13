import { Chapter } from '../../interfaces/Chapter.interface';
import DoneIcon from '@mui/icons-material/Done';
import { grey } from '@mui/material/colors';
import { ListItemButton, ListItemText, Avatar } from '@mui/material';
import React from 'react';
import { useAppSelector, useAppDispatch } from '../../redux/hooks';
import { setChapter } from '../../redux/slices/chapter';

interface MainNavItemProps {
  chapter?: Chapter;
}

export default function MainNavItem(props: MainNavItemProps) {
  const chapter = props.chapter!;
  const chapterBigTitle = `Chapter ${chapter ? chapter.chapterId : 0}`;
  const selectedChapter = useAppSelector((state) => state.chapter);
  const dispatch = useAppDispatch();

  const handleSelectChapter = () => {
    dispatch(setChapter(chapter!));
  };
  return (
    <React.Fragment>
      <ListItemButton
        onClick={handleSelectChapter}
        sx={{
          marginRight: '5px',
          backgroundColor:
            chapter.chapterId === selectedChapter.chapterId
              ? '#1976d21a'
              : null,
          borderRadius: '0 30px 30px 0',
          borderLeft: 5,
          borderLeftColor:
            chapter.chapterId === selectedChapter.chapterId
              ? 'primary.main'
              : '#1976d200',
          ':hover': { borderLeftColor: 'rgba(0,0,0,.2)' }
        }}
      >
        <ListItemText primary={chapterBigTitle} secondary={chapter.title} />
        {chapter.chapterStatus ? (
          <Avatar
            sx={{ bgcolor: 'success.main', width: '27px', height: '27px' }}
          >
            <DoneIcon fontSize="small" />
          </Avatar>
        ) : null}
      </ListItemButton>
    </React.Fragment>
  );
}
