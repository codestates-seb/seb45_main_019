export interface Chapter {
  chapterId: number;
  title: string;
  wordId: Array<number>;
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

export interface ChapterListItem {
  title: string;
  chapterId: number;
  wordId: number[];
}

export interface ChapterList {
  data: Array<ChapterListItem>;
}
