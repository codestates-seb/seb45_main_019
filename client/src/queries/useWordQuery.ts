import api from '../common/utils/api';
import { useQuery } from '@tanstack/react-query';
import { WordInterface } from '../interfaces/Word.interface';
import { AxiosError } from 'axios';

const uri = '/words';

export const getWordQueryKey = (id: number) => [uri, id];

export const useWordQuery = (query: (string | number)[]) => {
  return useQuery({
    queryKey: query,
    queryFn: () =>
      api(`${query[0]}/${String(query[1])}`).then(
        ({ data }) => data.data as WordInterface
      ),
    onError: (err: AxiosError) => err
  });
};
