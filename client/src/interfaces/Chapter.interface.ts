export interface Chapter {
  chapterId: number;
  title: string;
  wordId: Array<number>;
  chapterStatus?: boolean;
  learningChapterId?: number;
  progress?: (0 | 1 | 2)[];
}

export interface UserChapterListItem {
  chapterId: number;
  chapterStatus: boolean;
  progress: (0 | 1 | 2)[];
}

export interface UserChapter {
  chapterList: Array<UserChapterListItem>;
  learningChapterId: number;
}
