import api from '../common/utils/api';
import { useQuery } from '@tanstack/react-query';
import { UserChapterListItem } from '../interfaces/Chapter.interface';

export const QUERY_KEY = '/userChapter';

const fetcher = async (
  memberId: number,
  chapterId: number
): Promise<UserChapterListItem> => {
  const response = await api(`/manage/${memberId}/${chapterId}`, 'get');
  return response.data.data;
};

const useUserChapterQuery = (memberId: number, chapterId: number) => {
  return useQuery(
    [QUERY_KEY, memberId, chapterId],
    () => fetcher(memberId, chapterId),
    {
      refetchOnWindowFocus: false,
      retry: 0
    }
  );
};

export default useUserChapterQuery;
