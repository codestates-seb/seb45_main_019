import { Box, Typography } from '@mui/material';
import { grey } from '@mui/material/colors';

export default function GuideBook() {
  return (
    <Box sx={{ width: '100%', background: grey[200] }}>
      <Typography variant="h4" fontWeight={600}>
        Guide Book 자리
      </Typography>
    </Box>
  );
}
