import { Box, Typography } from '@mui/material';
import { grey } from '@mui/material/colors';
import { useAppSelector } from '../../redux/hooks';

export default function GuideBook() {
  const chapter = useAppSelector((state) => state.chapter);
  return (
    <Box sx={{ width: '100%', background: grey[200] }}>
      <Typography variant="h4" fontWeight={600}>
        Guide Book 자리
        <div>
          {chapter.chapterWords.map((el) => (
            <p key={el}>단어 ID : {el}</p>
          ))}
        </div>
      </Typography>
    </Box>
  );
}
