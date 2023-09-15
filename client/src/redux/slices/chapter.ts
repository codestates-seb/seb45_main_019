import { createSlice } from '@reduxjs/toolkit';
import { RootState } from '../store';
import { Chapter } from '../../interfaces/Chapter.interface';

const initialState: Chapter = {
  title: '',
  chapterId: 0,
  wordId: [0],
  chapterStatus: false,
  progress: [0]
};

export const chapterSlice = createSlice({
  name: 'chapter',
  initialState,
  reducers: {
    setChapter: (state, action: { payload: Chapter }) => {
      state = action.payload;
      return state;
    }
  }
});

export const { setChapter } = chapterSlice.actions;

export const selectChapter = (state: RootState) => state.chapter;

export default chapterSlice.reducer;
