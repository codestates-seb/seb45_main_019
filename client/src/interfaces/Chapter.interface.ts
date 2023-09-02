export interface Chapter {
  chapterId: number;
  title: string;
  chapterWords: Array<number>;
  chapterStatus?: boolean;
  learningChapterId?: number;
  progress?: number[];
}

export interface UserChapterListItem {
  chapterId: number;
  chapterStatus: boolean;
  progress: number[];
}

export interface UserChapter {
  chapterList: Array<UserChapterListItem>;
  learningChapterId: number;
}
