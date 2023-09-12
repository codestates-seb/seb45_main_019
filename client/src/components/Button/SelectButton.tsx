import React, { useState } from 'react';
import Button from '@mui/material/Button';
import { playText } from '../../common/utils/speak';

export default function SelectButton() {
  const [isThick, setIsThick] = useState(false);

  const handleClick = () => {
    playText('Hello');
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
        href={'#outlined-buttons'}
      >
        Hello
      </Button>
    </div>
  );
}
