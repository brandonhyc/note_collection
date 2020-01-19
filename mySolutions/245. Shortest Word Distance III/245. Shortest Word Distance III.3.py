class Solution:
    def shortestWordDistance(self, words: List[str], word1: str, word2: str) -> int:
        
        lastIndex = -1
        minDist = sys.maxsize
        
        for i in range(len(words)):
            word = words[i]
            if word == word1 or word == word2:
                if lastIndex == -1:
                    lastIndex = i
                    continue
                # found one side matching
                if (words[lastIndex] == word and word1 == word2) or words[lastIndex] != word:
                    minDist = min(i - lastIndex, minDist)
                    lastIndex = i  
                elif words[lastIndex] == word:
                    lastIndex = i
        
        return minDist