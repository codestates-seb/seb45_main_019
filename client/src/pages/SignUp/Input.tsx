import { TextField, Typography } from '@mui/material';
import React, { useState } from 'react';
import { useValidation } from './validation';

export default function Input(props: {
  autoComplete?: string;
  name?: string;
  id?: string;
  label?: string;
  required?: boolean;
}) {
  const [value, setValue] = useState('');
  const [valueIsValid, setValueIsValid] = useState(false);
  const [errorMsg, setErrorMsg] = useState('');

  const validation = useValidation(props.id)

  const handleValueChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setValue(event.target.value);

    const result = validation(value)
    setValueIsValid(result.valid)
    setErrorMsg(result.msg);
  };
  return (
    <>
      <TextField
        autoComplete={props.autoComplete}
        name={props.name}
        required={props.required}
        fullWidth
        id={props.id}
        label={props.label}
        // eslint-disable-next-line jsx-a11y/no-autofocus
        autoFocus
        value={value}
        onChange={handleValueChange}
      />
      {valueIsValid ? null : (
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
