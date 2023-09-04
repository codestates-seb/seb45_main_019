import { AppBar, Box, Toolbar, Button } from '@mui/material';

const pages = [
  { label: '내 단어장', url: '/Main' }, //임시로 넣어둔 url
  { label: 'Leaderboard', url: '/Main' },
  { label: 'MyPage', url: '/Main' }
];
export default function Header() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="fixed">
        <Toolbar sx={{ justifyContent: 'space-between' }}>
          <img
            src="./images/main_logo1.png"
            alt="Main Logo"
            style={{ height: '32px', marginRight: '8px' }}
          />
          <Box
            sx={{
              display: 'flex',
              marginLeft: 'auto'
            }}
          >
            {pages.map((item) => (
              <Button
                variant="contained"
                href={item.url}
                key={item.label}
                sx={{ color: '#fff', ml: 2 }}
              >
                {item.label}
              </Button>
            ))}
          </Box>
          <Button variant="contained" href="#contained-buttons" sx={{ ml: 2 }}>
            Log in
          </Button>
          <Button variant="contained" href="#contained-buttons" sx={{ ml: 2 }}>
            Sign Up
          </Button>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
