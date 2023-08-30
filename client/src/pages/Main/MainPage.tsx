import React from 'react';
import { useAppSelector, useAppDispatch } from '../../redux/hooks';
import { setUser } from '../../redux/slices/user';

function MainPage() {
  const user = useAppSelector((state) => state.user);
  const dispatch = useAppDispatch();

  return (
    <div>
      <h1>I Learn</h1>
      <div>{user.email}</div>
      <div>{user.memberId}</div>
      <div>{user.name}</div>
      <button
        onClick={() =>
          dispatch(setUser({ email: 'moses', name: 'moses', memberId: 10 }))
        }
      >setUser</button>
    </div>
  );
}

export default MainPage;
