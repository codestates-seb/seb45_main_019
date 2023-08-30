import { createSlice } from '@reduxjs/toolkit';
import { RootState } from '../store';

export interface UserState {
  email: string;
  name: string;
  memberId: number;
}

const initialState: UserState = {
  email: '',
  name: '',
  memberId: 1
};

export const userSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    setUser: (state, action) => {
      state.email = action.payload.email;
      state.name = action.payload.name;
      state.memberId = action.payload.memberId;
      return state;
    }
  }
});

export const { setUser } = userSlice.actions;

export const selectUser = (state: RootState) => state.user;

export default userSlice.reducer;
