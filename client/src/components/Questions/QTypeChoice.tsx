import { Box, Button, Typography } from '@mui/material';
import { Learning } from '../../interfaces/Learning.interface';

export interface QTypeProps {
  question: Learning;
  handleChangeUserInput?: (e: React.ChangeEvent<HTMLInputElement>) => void;
  handleClickUserInput?: (e: React.MouseEvent<HTMLElement>) => void;
  status: string;
}

export default function QTypeChoice(props: QTypeProps) {
  const question = props.question;
  const handleClick = props.handleClickUserInput!;
  const status = props.status;

  function exampleRender() {
    return question.examples!.map((el, idx) => {
      return (
        <Button
          key={idx}
          onClick={(e) => handleClick(e)}
          disabled={status === 'clicked'}
        >
          {el}
        </Button>
      );
    });
  }
  return (
    <Box>
      <Typography variant="h3" gutterBottom>
        {question.question}
      </Typography>
      <Typography variant="h4" gutterBottom>
        다음 중 알맞은 뜻은 무엇인가요?
      </Typography>
      {exampleRender()}
    </Box>
  );
}
