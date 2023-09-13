export interface LearningInterface {
  questionNum: number;
  questionType: number;
  question: string; // 뜻 또는 단어
  examples: string[]; // 예시 선택지
  correct: number; // examples의 정답인 단어의 인덱스
  translation: string;
}
