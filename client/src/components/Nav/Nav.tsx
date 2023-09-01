import { Box, List, ListItemButton, ListItemText, Avatar } from '@mui/material';
import DoneIcon from '@mui/icons-material/Done';
import { grey } from '@mui/material/colors';

export default function Nav() {
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
        <ListItemButton sx={{ borderBottom: 1, borderColor: grey[200] }}>
          <ListItemText
            primary="Chapter 1"
            primaryTypographyProps={{ style: { overflowWrap: 'break-word' } }}
            secondary="인사 나누기"
          />
          <Avatar sx={{ bgcolor: 'success.light' }}>
            <DoneIcon />
          </Avatar>
        </ListItemButton>
        <ListItemButton sx={{ borderBottom: 1, borderColor: grey[200] }}>
          <ListItemText primary="Chapter 2" secondary="활동에 대해 말하기" />
        </ListItemButton>
      </List>
    </Box>
  );
}
