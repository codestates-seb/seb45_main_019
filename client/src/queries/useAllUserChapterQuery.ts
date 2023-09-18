import api from '../common/utils/api';
import { useQuery } from '@tanstack/react-query';
import { UserChapter } from '../interfaces/Chapter.interface';

export const QUERY_KEY = '/allUserChapter';

const fetcher = async (memberId: number): Promise<UserChapter> => {
  const response = await api(`/manage/${memberId}`, 'get');
  return response.data;
};

const useAllUserChapterQuery = (memberId: number) => {
  return useQuery<UserChapter>([QUERY_KEY, memberId], () => fetcher(memberId));
};

export default useAllUserChapterQuery;
