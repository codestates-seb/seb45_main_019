import { createSlice } from '@reduxjs/toolkit';
import { RootState } from '../store';
import { UserState } from '../../interfaces/User.interface';

const initialState: UserState = {
  email: '',
  username: '',
  userId: 0,
  nickname: '',
  point: 0,
  memberStatus: false
};

export const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    setUser: (state, action: { payload: UserState }) => {
      state.email = action.payload.email;
      state.username = action.payload.username;
      state.userId = action.payload.userId;
      state.nickname = action.payload.nickname;
      state.point = action.payload.point;
      state.memberStatus = action.payload.memberStatus;
      return state;
    }
  }
});

export const { setUser } = userSlice.actions;

export const selectUser = (state: RootState) => state.user;

export default userSlice.reducer;
