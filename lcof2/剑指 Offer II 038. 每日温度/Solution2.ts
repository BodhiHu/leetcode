function solve(temperatures: number[]): number[] {
  const ret: number[] = [];

  for (let i = 0; i < temperatures.length; i++) {
    let j = i + 1;
    let n = 0;
    while (j < temperatures.length) {
      n++
      if (temperatures[j] > temperatures[i]) {
        break
      }
      if (j == temperatures.length - 1) {
        n = 0
      }
    }
    ret.push(n);
  }

  return ret;
}
