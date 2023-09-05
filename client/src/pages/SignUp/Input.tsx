import { TextField, Typography } from '@mui/material';
import React, { useState } from 'react';
import { useValidation } from './validation';

export default function Input(props: {
  autoComplete?: string;
  name?: string;
  id?: string;
  label?: string;
  required?: boolean;
  type?: string;
  checkValid?: boolean;
  isValid?: boolean;
  setIsValid: (state: boolean) => void;
  autoFocus?: boolean;
}) {
  const [value, setValue] = useState('');
  const [errorMsg, setErrorMsg] = useState('');

  const validation = useValidation(props.id);

  const handleValueChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setValue(event.target.value);
    if (props.checkValid) {
      const result = validation(event.target.value);

      props.setIsValid(result.valid);
      setErrorMsg(result.msg);
    }
  };
  return (
    <>
      <TextField
        fullWidth
        {...props}
        // eslint-disable-next-line jsx-a11y/no-autofocus
        autoFocus
        value={value}
        onChange={handleValueChange}
      />
      {props.isValid ? null : (
        <Typography
          variant="overline"
          display="block"
          gutterBottom
          sx={{ color: 'warning.main', height: 10, pl: 1 }}
        >
          {errorMsg}
        </Typography>
      )}
    </>
  );
}
