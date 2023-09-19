/* eslint-disable jsx-a11y/no-autofocus */
import * as React from 'react';
import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogContentText from '@mui/material/DialogContentText';
import DialogTitle from '@mui/material/DialogTitle';
import { DialogProps } from './DialogInterface';

export default function AlertDialog({
  open,
  setOpen,
  title,
  content,
  onConfirm
}: DialogProps) {
  const handleClose = () => {
    setOpen(false);
    onConfirm && onConfirm();
  };

  return (
    <div>
      <Dialog
        open={open}
        aria-labelledby={title}
        aria-describedby={content}
        onClose={() => handleClose()}
      >
        <DialogTitle id={title}>{title}</DialogTitle>
        <DialogContent>
          <DialogContentText id={content}>{content}</DialogContentText>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose} autoFocus>
            확인
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}
