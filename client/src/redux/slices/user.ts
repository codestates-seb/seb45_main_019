import { createSlice } from '@reduxjs/toolkit';
import { RootState } from '../store';

export interface UserState {
  email: string;
  username: string;
  user_Id: number;
  nickname: string;
  point: number;
  memberStatus: boolean;
}

const initialState: UserState = {
  email: '',
  username: '',
  user_Id: 0,
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
      state.user_Id = action.payload.user_Id;
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
