import { Box, List } from '@mui/material';
import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import NavItem from './NavItem';

interface NavProps {
  ids: number[];
  args: {
    selectedId: number;
    setSelectedId: (wordId: number) => void;
    getTitle: (id: number) => string | undefined;
    getSubTitle: (id: number) => string | undefined;
  };
}
export default function Nav({ ids, args }: NavProps) {
  return (
    <Box
      sx={{
        width: '100%',
        maxWidth: 270,
        padding: 0,
        backgroundColor: '#fff',
        position: 'fixed',
        zIndex: 10
      }}
    >
      <Box
        sx={{
          paddingLeft: '24px',
          height: '70px',
          display: 'flex',
          alignItems: 'center'
        }}
      >
        <Link to="/">
          <img src="./images/main-logo.png" alt="Main Logo" />
        </Link>
      </Box>
      <List
        sx={{
          overflowY: 'auto',
          height: 'calc(100vh - 70px)',
          padding: 0,
          '&::-webkit-scrollbar': {
            width: '0.4em',
            backgroundColor: 'rgba(0,0,0,.0)'
          },
          '&::-webkit-scrollbar-track': {
            boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)',
            webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)'
          },
          '&:hover::-webkit-scrollbar-thumb': {
            transition: 'all 1s ease',
            backgroundColor: 'rgba(0,0,0,.2)'
          },
          '&::-webkit-scrollbar-thumb': {
            borderRadius: '20px',
            backgroundColor: 'rgba(0,0,0,.0)'
          }
        }}
      >
        {ids.map((id) => (
          <NavItem key={id} listItem={{ id: id, ...args }}></NavItem>
        ))}
        {ids.length === 0 && <div>표시할 항목이 없습니다.</div>}
      </List>
    </Box>
  );
}
