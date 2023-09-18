import { Box } from '@mui/material';
import { useAppSelector } from '../../redux/hooks';
import { useNavigate } from 'react-router';
import { useEffect } from 'react';

export default function WordPage() {
  const user = useAppSelector((state) => state.user);
  const navigate = useNavigate();

  useEffect(() => {
    console.log(user);

    !user.memberStatus && navigate('/signin');
  }, []);

  return (
    <Box sx={{ marginTop: '500px' }}>
      <p>word page ..</p>
    </Box>
  );
}
