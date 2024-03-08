from typing import List


class Solution2:
  @staticmethod
  def minWords(beginWord: str, endWord: str, wordList: List[str]) -> int:
    if len(wordList) == 0:
      return 0
    if endWord not in wordList:
      return 0
    if beginWord == endWord:
      return 0

    # while True:
    nextCandidates = []
    for word in wordList:
      diffCount = 0
      for i in range(len(word)):
        if word[i] != beginWord[i]:
          diffCount += 1
        if diffCount > 1:
          break
      if diffCount == 1:
        nextCandidates.append(word)

    if len(nextCandidates) == 0:
      return 0

    minCnt = -1
    # print('nextCandidates:', nextCandidates)
    for nextWord in nextCandidates:
      for word in nextCandidates:
        diffCount = 0
        for i in range(len(word)):
          if word[i] != endWord[i]:
            diffCount += 1
          if diffCount > 1:
            break
        if diffCount == 1:
          return 3

      leftWordList = [ *wordList ]
      leftWordList.remove(nextWord)
      cnt = Solution2.minWords(nextWord, endWord, leftWordList)
      if cnt > 0:
        minCnt = min(cnt if minCnt == -1 else minCnt, cnt)

      if minCnt > 0:
        minCnt += 1
        return minCnt

      return 0


if __name__ == "__main__":
  print(Solution2.minWords("cat", "dog", ["cot", "dot"]))
  print(Solution2.minWords("hit", "cog", ["hot","dot","dog","lot","log","cog"]))
  print(Solution2.minWords("hit", "cog", ["hot","dot","dog","lot","log"]))
  print(Solution2.minWords("abc", "xyz", ["abd", "def", "xyz"]))
