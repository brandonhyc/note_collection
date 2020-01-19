class WordDistance:

    
    wordMap = {}
    
    def __init__(self, words: List[str]):
        self.wordMap = {}
        
        for i in range(len(words)):
            word = words[i]
            if word not in self.wordMap:
                self.wordMap[word] = []
            self.wordMap[word].append(i)
            
    def shortest(self, word1: str, word2: str) -> int:
        wordL1 = self.wordMap[word1]
        wordL2 = self.wordMap[word2]
        
        ptr1 = 0
        ptr2 = 0
        minDist = sys.maxsize
        while ptr1 < len(wordL1) and ptr2 < len(wordL2):
            index1 = wordL1[ptr1]
            index2 = wordL2[ptr2]
            
            minDist = min(abs(index1 - index2), minDist)
            if index1 < index2:
                ptr1 += 1
            else:
                ptr2 += 1
        
        return minDist


# Your WordDistance object will be instantiated and called as such:
# obj = WordDistance(words)
# param_1 = obj.shortest(word1,word2)