import React, { useState } from 'react';
import Button from '@mui/material/Button';
import { playText } from '../../common/utils/speak';

interface SelectButtonProps {
  text: string;
  handleClickUserInput?: (e: React.MouseEvent<HTMLElement>) => void;
  status: string;
}
export default function SelectButton(props: SelectButtonProps) {
  const [isThick, setIsThick] = useState<string>('');
  const question = props.text;
  const handleClickUserInput = props.handleClickUserInput!;
  const status = props.status;

  const handleClick = (e: React.MouseEvent<HTMLElement>) => {
    playText(question);
    setIsThick(e.currentTarget.innerText);
    handleClickUserInput(e);
  };

  return (
    <Button
      variant="outlined"
      style={{
        borderWidth: question === isThick ? '4px' : '1px',
        borderColor: question === isThick ? 'gray' : 'inherit'
      }}
      onClick={(e) => handleClick(e)}
      disabled={status === 'clicked'}
    >
      {question}
    </Button>
  );
}
