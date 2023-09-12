import {
  Timeline,
  TimelineConnector,
  TimelineDot,
  TimelineItem,
  TimelineSeparator
} from '@mui/lab';
import { Progress } from './MainProgress';
import { Typography } from '@mui/material';

export default function QuestionProgress({ progress }: Progress) {
  function itemMapping(el: number, idx: number) {
    let statusColor = 'default';

    if (el === 1) {
      statusColor = 'success.main';
    } else if (el === 2) {
      statusColor = 'error.main';
    }

    return (
      <TimelineItem key={idx}>
        <TimelineSeparator>
          {idx === 0 ? null : <TimelineConnector />}
          <TimelineDot
            sx={{
              width: '40px',
              height: '40px',
              justifyContent: 'center',
              alignItems: 'center',
              boxShadow: 'rgba(0, 0, 0, 0.2) 0px 0px 10px',
              backgroundColor: statusColor,
              rotate: '90deg'
            }}
          >
            <Typography variant="subtitle2">{idx + 1}</Typography>
          </TimelineDot>
          {idx === 11 ? null : <TimelineConnector />}
        </TimelineSeparator>
      </TimelineItem>
    );
  }
  return (
    <Timeline
      position="right"
      sx={{
        rotate: '-90deg',
        position: 'absolute',
        left: '47%',
        top: '-350px'
      }}
    >
      {progress.map((el, idx) => {
        return itemMapping(el, idx);
      })}
    </Timeline>
  );
}
