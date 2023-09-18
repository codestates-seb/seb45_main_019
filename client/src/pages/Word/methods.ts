import { useQuery } from '@tanstack/react-query';
import { getWordQueryKey, useWordQuery } from '../../queries/useWordQuery';
import { useAppSelector } from '../../redux/hooks';
import api from '../../common/utils/api';
import { AddWordError } from '../../components/Word/AddWord';

export const getWordWord = (id: number) => {
  const query = getWordQueryKey(id);
  const { data } = useWordQuery(query);
  return data?.word;
};
export const getWordSub = (id: number) => {
  return undefined;
};

export const getUserWordIds = () => {
  const user = useAppSelector((state) => state.user);
  const queryKey = ['userWordIds', user.userId];

  const { data } = useQuery({
    queryKey: queryKey,
    queryFn: () =>
      api(`/words/members/${user.userId}`).then(({ data }) => {
        // console.log(data);
        return data;
      }),
    onError: (err: AddWordError) => {
      const data = err.response?.data;
      if (data.error) {
        /* empty */
      }
    }
  });

  return data?.data;
};
