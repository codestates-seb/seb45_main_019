import { Chapter, UserChapter } from '../../interfaces/Chapter.interface';

export const chapterData: Array<Chapter> = [
  {
    title: '인사 나누기',
    chapterId: 1,
    chapterWords: [1, 2, 3]
  },
  {
    title: '쇼핑 및 주문하기',
    chapterId: 2,
    chapterWords: [4, 5, 6]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 3,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 4,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 5,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 6,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 7,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 8,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 9,
    chapterWords: [71, 28, 66]
  },
  {
    title: '활동에 대해 말하기',
    chapterId: 10,
    chapterWords: [71, 28, 66]
  }
  // {
  //   title: '활동에 대해 말하기',
  //   chapterId: 3,
  //   chapterWords: [71, 28, 66]
  // },
  // {
  //   title: '활동에 대해 말하기',
  //   chapterId: 3,
  //   chapterWords: [71, 28, 66]
  // },
  // {
  //   title: '활동에 대해 말하기',
  //   chapterId: 3,
  //   chapterWords: [71, 28, 66]
  // },
  // {
  //   title: '활동에 대해 말하기',
  //   chapterId: 3,
  //   chapterWords: [71, 28, 66]
  // },
  // {
  //   title: 'end',
  //   chapterId: 3,
  //   chapterWords: [71, 28, 66]
  // }
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
