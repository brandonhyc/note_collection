class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        
        # we do BFS to find all the "next possible words" for each word in wordList
        #   In this BFS, we try to find a path from beginWord to EndWord
        
        # we do a DFS to find all the shortest possible path 
        #   In this DFS, we will use the dict "next possible words" as its branches
        
        nextWordsMap = {}
        wordDistance = {}
        shorestPaths = []
        
        self.bfs(beginWord, endWord, wordList, nextWordsMap, wordDistance)
        wordDistance[beginWord] = 0
        path = []
        path.append(beginWord)
        self.dfs(beginWord, endWord, nextWordsMap, wordDistance, path, shorestPaths)
        
        return shorestPaths
    
    def dfs(self, begin, end, nextWordsMap, wordDistance, path, shorestPaths):
        
        # if found endWord
        if (begin == end):
            shorestPaths.append(path[:])
            return

        nextWords = nextWordsMap.get(begin, [])
        for nw in nextWords:
            notIsAdjacent = wordDistance.get(nw) - 1 != wordDistance.get(begin)
            if notIsAdjacent:
                continue
            path.append(nw)
            self.dfs(nw, end, nextWordsMap, wordDistance, path, shorestPaths)
            del path[-1]
        
    
    def bfs(self, begin, end, wordList, nextWordsMap, wordDistance):
        
        dictSet = set(wordList)

        queue = collections.deque()
        queue.append(begin)
        level = 0
        foundEnd = False
        
        while len(queue) > 0 and not foundEnd:
            level += 1
            queueSize = len(queue)
            
            for i in range(queueSize):
                word = queue.popleft()
                nextWords = self.getNextWords(dictSet, word)
                nextWordsMap[word] = nextWords
                
                for w in nextWords:
                    if w not in wordDistance:
                        wordDistance[w] = level
                        queue.append(w)
                    
                    if w == end:
                        foundEnd = True;
        
    
    def getNextWords(self, dictSet, word):
        nextWords = []
        
        for i in range(len(word)):
            wordArr = list(word)
            for j in range(26):
                ch = chr(ord('a') + j)
                wordArr[i] = ch 
                nextWord = "".join(wordArr)
                
                if nextWord in dictSet and nextWord != word:
                    nextWords.append(nextWord)
        
        return nextWords
        
        


-------------------------------------------------------------------------------




          ["hit","hot","dot","dog","cog"],
          ["hit","hot","lot","log","cog"]
        
        
        beginWord = "hit", endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]
        
        BFS: 
            curWord = hit
            wordDistance: hit: 0  
            nextPossibleMap: hit: [hot]
            ------------
            hot
            {hit: 0, hot: 1}
            {hit: [hot], hot: [hit, dot, lot]}
            ---
            dot
            {hit: 0, hot: 1, dot: 2, lot: 2}
            {hit: [hot], hot: [hit, dot, lot], dot: [lot, hot]}
            --
            lot
            {hit: 0, hot: 1, dot: 2, lot: 2, log: 3}
            {hit: [hot], hot: [hit, dot, lot], dot: [lot, hot], lot: [hit, log]}
            --
            log
            {hit: 0, hot: 1, dot: 2, lot: 2, dog: 2, log:3 , cog: 4}
            {hit: [hot], hot: [hit, dot, lot], dot: [lot, hot, dog], lot: [hit, log], dog: [..., log], log: [cog]}
            
            
        DFS:
            {hit: 0, hot: 1, dot: 2, lot: 2, dog: 2, log:3 , cog: 4}
            hit -> hot: [hit, dot, lot]
                                        -> x hit 0 < 1 not to revistied, cancel
                                        -> dot 2 == hot 1 + 1 good [lot, hot, dog] -> dog 2 == dot == 2, not visiting | lot 
                                        -> lot 2 == hot 1 + 1 good

            