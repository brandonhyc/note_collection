import sys
class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        
        lastWord = None
        lastWordPos = -1
        minDiff = sys.maxsize
        
        for i in range(len(words)):
          
          if words[i] == word1 or words[i] == word2:
            # found a match
            # update if 1. init 2. equals lastWord
            if lastWord == None:
              lastWord = words[i]
              lastWordPos = i
            # found a pair
            elif lastWord != words[i] or word1 == word2:
              minDiff = min(minDiff, i - lastWordPos)
              
              lastWord = words[i]
              lastWordPos = i
            elif lastWord == words[i]:
              lastWord = words[i]
              lastWordPos = i
          
        return minDiff
        
        
        