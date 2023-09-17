import api from '../common/utils/api';
import { useQuery } from '@tanstack/react-query';
import { Learning } from '../interfaces/Learning.interface';

export const QUERY_KEY = '/learning';

const fetcher = async (
  chapterId: number,
  questionNum: number
): Promise<Learning> => {
  const response = await api(`/learning/${chapterId}/${questionNum}`, 'get');
  return response.data.data;
};

const useLearningQuery = (chapterId: number, questionNum: number) => {
  return useQuery(
    [QUERY_KEY, chapterId, questionNum],
    () => fetcher(chapterId, questionNum),
    {
      refetchOnWindowFocus: false,
      retry: 0
    }
  );
};

export default useLearningQuery;
