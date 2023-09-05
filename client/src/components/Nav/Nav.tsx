import { Box, List } from '@mui/material';
import { Chapter } from '../../interfaces/Chapter.interface';
import NavItem from './NavItem';

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
        overflowY: 'scroll',
        padding: 0
      }}
    >
      <List sx={{ padding: 0 }}>
        {location === '/'
          ? chapterList?.map((el) => (
              <NavItem key={el.chapterId} chapter={el} />
            ))
          : null}
      </List>
    </Box>
  );
}
