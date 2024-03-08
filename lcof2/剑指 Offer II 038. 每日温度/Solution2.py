from typing import List


def solve(temperatures: List[int]) -> List[int]:
  ret = []
  for i, temp in enumerate(temperatures):
    j = i + 1
    n = 0
    while j < len(temperatures):
      n += 1
      if temperatures[j] > temp:
        break
      if j == len(temperatures) - 1:
        n = 0
    ret.append(n)

  return ret
