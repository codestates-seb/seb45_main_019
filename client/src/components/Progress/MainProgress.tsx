import Timeline from '@mui/lab/Timeline';
import TimelineItem from '@mui/lab/TimelineItem';
import TimelineSeparator from '@mui/lab/TimelineSeparator';
import TimelineConnector from '@mui/lab/TimelineConnector';
import TimelineContent from '@mui/lab/TimelineContent';
import TimelineDot from '@mui/lab/TimelineDot';
import TimelineOppositeContent from '@mui/lab/TimelineOppositeContent';
import { Typography } from '@mui/material';
import { grey } from '@mui/material/colors';

export interface Progress {
  progress: (0 | 1 | 2)[];
  questionNum?: number;
}
export default function MainProgress({ progress }: Progress) {
  console.log(progress);
  function itemMapping(el: number, idx: number) {
    let status = '';
    let point = '';
    let statusColor = 'default';
    let qType = '';
    let qTypeNo = 0;

    if (el === 1) {
      status = 'Success';
      statusColor = 'success.main';
      if (idx === 3 || idx === 7 || idx === 11) {
        point = '+ 3';
      } else if (idx === 2 || idx === 6 || idx === 10) {
        point = '+ 2';
      } else {
        point = '+ 1';
      }
    } else if (el === 2) {
      status = 'Fail';
      statusColor = 'error.main';
      point = '+ 0';
    }

    if (idx === 0 || idx === 4 || idx === 8) {
      qType = '영단어 고르기';
    } else if (idx === 1 || idx === 5 || idx === 9) {
      qType = '뜻 고르기';
    } else if (idx === 2 || idx === 6 || idx === 10) {
      qType = '스펠링 입력하기';
    } else {
      qType = '빈칸 채우기';
    }

    if (idx === 0 || idx === 1 || idx === 2 || idx === 3) {
      qTypeNo = 1;
    } else if (idx === 4 || idx === 5 || idx === 6 || idx === 7) {
      qTypeNo = 2;
    } else {
      qTypeNo = 3;
    }

    return (
      <TimelineItem key={idx}>
        <TimelineOppositeContent
          sx={{ margin: '19px 0', fontSize: '0.8rem' }}
          color={grey[700]}
        >
          {qType} {qTypeNo}
        </TimelineOppositeContent>
        <TimelineSeparator>
          {idx === 0 ? null : <TimelineConnector />}
          <TimelineDot
            sx={{
              width: '40px',
              height: '40px',
              justifyContent: 'center',
              alignItems: 'center',
              boxShadow: 'rgba(0, 0, 0, 0.2) 0px 0px 10px',
              backgroundColor: statusColor
            }}
          >
            <Typography variant="subtitle2">{idx + 1}</Typography>
          </TimelineDot>
          {idx === 11 ? null : <TimelineConnector />}
        </TimelineSeparator>
        <TimelineContent
          color="text.secondary"
          sx={{ margin: '9px 0', fontSize: '0.8rem' }}
        >
          {status}
          <br />
          {point}
        </TimelineContent>
      </TimelineItem>
    );
  }

  return (
    <Timeline
      position="right"
      sx={{
        maxHeight: '390px',
        overflowY: 'auto',
        '&::-webkit-scrollbar': {
          width: '0.4em',
          backgroundColor: 'rgba(0,0,0,.0)'
        },
        '&::-webkit-scrollbar-track': {
          boxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)',
          webkitBoxShadow: 'inset 0 0 6px rgba(0,0,0,0.00)'
        },
        '&:hover::-webkit-scrollbar-thumb': {
          transition: 'all 1s ease',
          backgroundColor: 'rgba(0,0,0,.2)'
        },
        '&::-webkit-scrollbar-thumb': {
          borderRadius: '20px',
          backgroundColor: 'rgba(0,0,0,.0)'
        }
      }}
    >
      {progress &&
        progress.map((el, idx) => {
          return itemMapping(el, idx);
        })}
    </Timeline>
  );
}
