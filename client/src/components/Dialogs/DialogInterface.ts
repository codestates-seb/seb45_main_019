export interface DialogProps {
  open: boolean;
  setOpen: (open: boolean) => void;
  title?: string;
  content?: string;
  onConfirm?: () => void;
}
