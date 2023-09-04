import { createSlice } from '@reduxjs/toolkit';
import { RootState } from '../store';
import { Chapter } from '../../interfaces/Chapter.interface';

const initialState: Chapter = {
  title: '인사 나누기',
  chapterId: 1,
  chapterWords: [1, 2, 3],
  chapterStatus: false,
  learningChapterId: 1,
  progress: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
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
