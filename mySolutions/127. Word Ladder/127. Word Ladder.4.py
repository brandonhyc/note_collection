from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
      if endWord not in wordList:
        return 0
      wordList.remove(endWord)

      wordListSet = set(wordList)
      leftSet = {beginWord}
      rightSet = {endWord}
      visited = set()
      length = 0

      while len(leftSet) > 0 and len(rightSet) > 0:
        # print("leftSet", leftSet, "rightSet", rightSet)
        nextSet = set()
        length += 1
        
        for word in leftSet:
          # try all the conversion
          for i in range(len(word)):
            nextWordArr = list(word)

            for j in range(26):
              ch = chr(ord('a') + j)
              if ch == nextWordArr[i]:
                continue
              
              nextWordArr[i] = ch
              nextWord = ''.join(nextWordArr)
              if nextWord in rightSet:
                return length + 1

              if (nextWord in wordListSet) and (nextWord not in visited):
                nextSet.add(nextWord)
                visited.add(nextWord)
          
        leftSet = nextSet

        if len(leftSet) > len(nextSet):
          temp = leftSet
          leftSet = rightSet
          rightSet = temp

      return 0
