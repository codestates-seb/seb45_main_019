export function pointAcc(progress: (0 | 1 | 2)[]) {
  return progress.reduce((acc, cur, i) => {
    if (cur === 0 || cur === 2) return acc;

    if (cur === 1)
      if (i === 3 || i === 7 || i === 11) return acc + 3;
      else if (i === 2 || i === 6 || i === 10) return acc + 2;
      else return acc + 1;
    return acc;
  }, 0);
}
