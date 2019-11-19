# Bad, TLE in python
from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        queue = deque()
        queue.append(beginWord)
        length = 0
        
        while queue:
          
          length += 1
          size = len(queue)
          
          for i in range(size):
            curWord = queue.popleft()
            
            if curWord == endWord:
              return length
            cands = self.getNextWords(wordList, curWord)
            for nextWord in cands:
              wordList.remove(nextWord)
              queue.append(nextWord)
            
        return 0
      
    def getNextWords(self, wordList, curWord):
      list = []
      for word in wordList:
        diff = 0
        for i in range(len(word)):
          if word[i] != curWord[i]:
            diff += 1  
        if diff == 1:
          list.append(word)
      return list