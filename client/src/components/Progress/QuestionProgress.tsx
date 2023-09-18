import {
  Timeline,
  TimelineConnector,
  TimelineDot,
  TimelineItem,
  TimelineSeparator
} from '@mui/lab';
import { Progress } from './MainProgress';
import { Typography } from '@mui/material';

export default function QuestionProgress({ progress, questionNum }: Progress) {
  function itemMapping(el: number, idx: number) {
    let statusColor = 'default';

    if (el === 1) {
      statusColor = 'success.main';
    } else if (el === 2) {
      statusColor = 'error.main';
    } else if (idx === questionNum! - 1) statusColor = '#fff';

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
              boxShadow:
                idx === questionNum! - 1 ? '' : (theme) => theme.shadows[3],
              backgroundColor: statusColor,
              rotate: '90deg',
              borderWidth: idx === questionNum! - 1 ? '3px' : '',
              borderColor: idx === questionNum! - 1 ? 'primary.main' : '',
              color: idx === questionNum! - 1 ? 'primary.main' : ''
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
