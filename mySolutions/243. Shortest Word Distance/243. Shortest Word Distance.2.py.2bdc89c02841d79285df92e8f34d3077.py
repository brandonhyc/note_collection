class Solution:
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        
        w1 = -1
        w2 = -1
        minDist = sys.maxsize
        for i in range(len(words)): 
            if words[i] == word1:
                w1 = i
            if words[i] == word2:
                w2 = i
                
            if w1 != -1 and w2 != -1:
                minDist = min(abs(w1 - w2), minDist)
                
        return minDist