export function pointAcc(progress: (0 | 1 | 2)[]) {
  return progress.reduce((cur, acc, i) => {
    if (cur === 0 || cur === 2) return acc;

    if (cur === 1)
      if (i === 9 || i === 10 || i === 11) return acc + 3;
      else if (i === 2 || i === 5 || i === 8) return acc + 2;
      else return acc + 1;
    console.log(acc);
    return acc;
  }, 0);
}
