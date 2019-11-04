import sys
class WordDistance:
    wordPos = {}
    
    def __init__(self, words: List[str]):
      for word in words:
        self.wordPos[word] = []
      for i in range(len(words)):
        self.wordPos[words[i]].append(i)

    def shortest(self, word1: str, word2: str) -> int:
      arr1 = self.wordPos[word1]
      arr2 = self.wordPos[word2]

      pos1 = 0
      pos2 = 0
      minDiff = sys.maxsize
      
      while pos1 < len(arr1) and pos2 < len(arr2):
        minDiff = min(abs(arr1[pos1] - arr2[pos2]), minDiff)
        if arr1[pos1] < arr2[pos2]:
          pos1 += 1
        else:
          pos2 += 1
      
      return minDiff

# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)