import { BarChart } from '@mui/x-charts/BarChart';

export default function RecordChart() {
  const type1 = {
    data: [1, 2, 1, 1, 3, 0, 0, 2, 2, 3, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0],
    label: '영단어 고르기',
    color: '#34ace0'
  };
  const type2 = {
    data: [3, 1, 4, 2, 1, 3, 1, 4, 2, 1, 3, 1, 4, 0, 0, 0, 0, 0, 0, 0],
    label: '뜻 고르기',
    color: '#ffb142'
  };
  const type3 = {
    data: [3, 2, 4, 5, 1, 3, 2, 4, 5, 1, 3, 2, 4, 0, 0, 0, 0, 0, 0, 0],
    label: '스펠링 입력하기',
    color: '#474787'
  };
  const type4 = {
    data: [3, 2, 4, 5, 1, 3, 2, 4, 5, 1, 3, 2, 4, 0, 0, 0, 0, 0, 0, 0],
    label: '빈칸 채우기',
    color: '#218c74'
  };

  const xAxis = {
    label: '챕터',
    scaleType: 'band' as const,
    data: [
      '1',
      '2',
      '3',
      '4',
      '5',
      '6',
      '7',
      '8',
      '9',
      '10',
      '11',
      '12',
      '13',
      '14',
      '15',
      '16',
      '17',
      '18',
      '19',
      '20'
    ]
  };

  console.log(xAxis.data);
  const yAxis = {
    label: '맞춘 문제'
  };

  const chapters = [
    { ...type1, stack: 'total' },
    { ...type2, stack: 'total' },
    { ...type3, stack: 'total' },
    { ...type4, stack: 'total' }
  ];
  return (
    <BarChart height={300} series={chapters} xAxis={[xAxis]} yAxis={[yAxis]} />
  );
}
