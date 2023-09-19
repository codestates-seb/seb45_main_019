import { useMutation, useQueryClient } from '@tanstack/react-query';
import api from '../common/utils/api';
import { QUERY_KEY as chapterKey } from './useUserChapterQuery';

interface PatchParam {
  memberId: number;
  chapterId: number;
  data: dataParam;
}

interface dataParam {
  chapterStatus: boolean;
  progress: (0 | 1 | 2)[];
  point: number;
}

const fetcher = ({ memberId, chapterId, data }: PatchParam) =>
  api(`/manage/${memberId}/${chapterId}`, 'patch', data);

const useSignUpMutation = () => {
  const queryClient = useQueryClient();

  return useMutation(fetcher, {
    onSuccess: () => {
      queryClient.invalidateQueries([chapterKey]);
    }
  });
};

export default useSignUpMutation;
