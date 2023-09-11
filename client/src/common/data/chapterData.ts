import { Chapter, UserChapter } from '../../interfaces/Chapter.interface';

export const chapterData: Array<Chapter> = [
  {
    title: '인사 나누기',
    chapterId: 1,
    wordId: [1, 2, 3]
  },
  {
    title: '쇼핑 및 주문하기',
    chapterId: 2,
    wordId: [4, 5, 6]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 3,
    wordId: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 3,
    wordId: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 5,
    wordId: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 3,
    wordId: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 7,
    wordId: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 3,
    wordId: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 3,
    wordId: [71, 28, 66]
  }
];

export const userChapterAllData: UserChapter = {
  chapterList: [
    {
      chapterId: 1,
      chapterStatus: true,
      progress: [1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1]
    },
    {
      chapterId: 2,
      chapterStatus: false,
      progress: [1, 1, 1, 1, 1, 1, 2, 2, 0, 0, 0, 0]
    },
    {
      chapterId: 3,
      chapterStatus: false,
      progress: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    }
  ],
  learningChapterId: 3
};
