import { useMutation, useQueryClient } from '@tanstack/react-query';
import api from '../common/utils/api';
import { QUERY_KEY as learningKey } from './useLearningQuery';
import { QUERY_KEY as chapterKey } from './useUserChapterQuery';

interface PatchParam {
  memberId: number;
  chapterId: number;
  questionNum: number;
  data: dataParam;
}

interface dataParam {
  chapterStatus: boolean;
  progress: (0 | 1 | 2)[];
  point: number;
}

const fetcher = ({ memberId, chapterId, data }: PatchParam) =>
  api(`/manage/${memberId}/${chapterId}`, 'patch', data);

const useLearningMutation = (
  memberId: number,
  chapterId: number,
  questionNum: number
) => {
  const queryClient = useQueryClient();

  return useMutation(fetcher, {
    onSuccess: () => {
      queryClient.invalidateQueries([chapterKey, memberId, chapterId]);
      queryClient.invalidateQueries([learningKey, chapterId, questionNum]);
    }
  });
};

export default useLearningMutation;
