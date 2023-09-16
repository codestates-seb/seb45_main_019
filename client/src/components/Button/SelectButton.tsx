import React, { useState } from 'react';
import Button from '@mui/material/Button';
import { playText } from '../../common/utils/speak';

interface SelectButtonProps {
  text: string;
}
export default function SelectButton({ text }: SelectButtonProps) {
  const [isThick, setIsThick] = useState(false);

  const handleClick = () => {
    playText(text);
    setIsThick(!isThick);
  };

  return (
    <div>
      <Button
        onClick={handleClick}
        variant="outlined"
        style={{
          borderWidth: isThick ? '4px' : '1px',
          borderColor: isThick ? 'gray' : 'inherit'
        }}
      >
        {text}
      </Button>
    </div>
  );
}
