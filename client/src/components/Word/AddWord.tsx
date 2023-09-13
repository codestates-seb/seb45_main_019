import React from 'react';
import { Button } from '@mui/material';
import { useMutation, useQuery, useQueryClient } from '@tanstack/react-query';
import api from '../../common/utils/api';
import { useAppSelector } from '../../redux/hooks';
import { AxiosError } from 'axios';

export default function AddWord(props: { wordId: number }) {
  const queryClient = useQueryClient();
  const user = useAppSelector((state) => state.user);
  console.log(user.userId);

  const { isLoading, error, data } = useQuery({
    queryKey: ['userWordIds'],
    queryFn: () => api(`/words/members/${user.userId}`).then(({ data }) => data)
  });
  console.log(data);

  const { mutate } = useMutation(
    () =>
      api(`/words/members/${user.userId}`, 'post', {
        wordId: props.wordId
      }).then((res) => console.log(res.data)),
    {
      onSuccess: () => queryClient.invalidateQueries(['userWordIds'])
    }
  );

  if (isLoading) return <div> 로딩중... </div>;

  if (error) {
    const myError = error as AxiosError;
    return <div> 에러: {myError.message} </div>;
  }
  return (
    <Button variant={'outlined'} onClick={() => mutate()}>
      단어장 추가
    </Button>
  );
}
