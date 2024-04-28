import api from '../common/utils/api';
import { useQuery } from '@tanstack/react-query';
import { ChapterList } from '../interfaces/Chapter.interface';

export const QUERY_KEY = '/allChapter';
const fetcher = async (): Promise<ChapterList> => {
  const response = await api('/learning', 'get');
  return response.data;
};

const useAllChapterQuery = () => {
  return useQuery<ChapterList>([QUERY_KEY], fetcher);
};

export default useAllChapterQuery;
