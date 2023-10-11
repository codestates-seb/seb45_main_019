export interface WordInterface {
  wordId: number;
  word: string;
  symbol: string;
  wordMeaning: string[];
  detailDescriptions: {
    category: string;
    descriptions: string[];
  }[];
  wordExample: string[];
  wordExampleMeaning: string[];
}
