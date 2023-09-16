export interface Chapter {
  chapterId: number;
  title: string;
  wordId: Array<number>;
  chapterStatus?: boolean;
  progress?: (0 | 1 | 2)[];
}

export interface UserChapterListItem {
  chapterId: number;
  chapterStatus: boolean;
  progress: (0 | 1 | 2)[];
}

export interface UserChapter {
  data: Array<UserChapterListItem>;
}

export interface ChapterListItem {
  title: string;
  chapterId: number;
  wordId: number[];
}

export interface ChapterList {
  data: Array<ChapterListItem>;
}
