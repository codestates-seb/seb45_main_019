import React from 'react';
import { Avatar, ListItemButton, ListItemText } from '@mui/material';
import DoneIcon from '@mui/icons-material/Done';

interface NavItemProps {
  listItem: {
    id: number;
    selectedId: number;
    setSelectedId: (wordId: number) => void;
    getTitle: (id: number) => string | undefined;
    getSubTitle: (id: number) => string | undefined;
  };
}
export default function NavItem({ listItem }: NavItemProps) {
  const { id, selectedId, setSelectedId, getTitle, getSubTitle } = listItem;
  const title = getTitle(id);
  const secondary = getSubTitle(id);
  return (
    <React.Fragment>
      <ListItemButton
        onClick={() => setSelectedId(id)}
        sx={{
          marginRight: '5px',
          backgroundColor: id === selectedId ? '#1976d21a' : null,
          borderRadius: '0 30px 30px 0',
          borderLeft: 5,
          borderLeftColor: id === selectedId ? 'primary.main' : '#1976d200',
          ':hover': { borderLeftColor: 'rgba(0,0,0,.2)' }
        }}
      >
        <ListItemText primary={title} secondary={secondary} />
      </ListItemButton>
    </React.Fragment>
  );
}
