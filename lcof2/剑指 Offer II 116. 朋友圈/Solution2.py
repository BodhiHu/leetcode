from typing import List


#     0 1 2 3 4 5 6 7
#     - - - - - - - -
# 0 - 1 1 0 0 1 0 0 0
# 1 - 1 1 0 1 0 0 0 0
# 2 - 0 0 1 0 0 0 0 0
# 3 - 0 1 0 1 0 0 0 0
# 4 - 1 0 0 0 1 1 0 0
# 5 - 0 0 0 0 1 1 0 0
# 6 - 0 0 0 0 0 0 1 0
# 7 - 0 0 0 0 0 0 0 1

class Solution2:
  @staticmethod
  def solve(graph: List[List[int]]) -> int:
    n = len(graph)
    # n = 0

    circle = set()
    for i, _ in enumerate(graph):
      if i in circle:
        continue
      for j, _ in enumerate(graph[i]):
        if j in circle:
          continue
        if i != j:
          if graph[i][j] == 1:
            circle.add(j)
            k = i + 1
            while k < len(graph):
              if graph[k][j] == 1:
                circle.add(k)
              k += 1
            n -= 1

    return n


if __name__ == "__main__":
  print(Solution2.solve(
    [
      [1,1,0],
      [1,1,0],
      [0,0,1]
    ]
  ))
  print(Solution2.solve(
    [
      [1,0,0],
      [0,1,0],
      [0,0,1]
    ]
  ))
  print(Solution2.solve(
    [
      [1,1,0,0,1,0,0,0],
      [1,1,0,1,0,0,0,0],
      [0,0,1,0,0,0,0,0],
      [0,1,0,1,0,0,0,0],
      [1,0,0,0,1,1,0,0],
      [0,0,0,0,1,1,0,0],
      [0,0,0,0,0,0,1,0],
      [0,0,0,0,0,0,0,1]
    ]
  ))
