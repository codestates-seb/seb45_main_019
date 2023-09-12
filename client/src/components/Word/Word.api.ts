import { AxiosError } from 'axios';
import api from '../../common/utils/api';
import { WordInterface } from '../../interfaces/Word.interface';

export const getWord = async (wordId: string) => {
  const wordInfo: WordInterface | AxiosError = await api(`/words/${wordId}`)
    .then(({ data }) => {
      return data.data;
    })
    .catch((error) => {
      console.log(error);
      const dummy: WordInterface = {
        wordId: 0,
        word: '',
        symbol: '',
        wordMeaning: [],
        detailCategories: [],
        detailDescriptions: [],
        wordExample: [],
        wordExampleMeaning: []
      };
      return dummy;
    });

  return wordInfo;
};
