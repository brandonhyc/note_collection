from collections import deque
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        # bfs
        queue = deque()
        queue.append(beginWord)
        wordMap = {}
        distance = {}
        depth = 0
        isFound = False
        wordSet = set(wordList)
        distance[beginWord] = 0

        while queue:
            size = len(queue)
            depth += 1

            for i in range(size):
                curWord = queue.popleft()
                nextWords = self.getNextWords(curWord, wordSet)
                wordMap[curWord] = nextWords
        
                for word in nextWords:
                    if word not in distance:
                        if word == endWord:
                            isFound = True
                        distance[word] = depth
                        queue.append(word)
            
            if isFound:
                break

        res = []
        path = []
        path.append(beginWord)
        self.dfs(beginWord, endWord, wordMap, distance, path, res)
        
        return res

    def getNextWords(self, curWord, wordSet):
        nextWords = []
        for i in range(len(curWord)):
            arr = list(curWord)

            for j in range(26):
                ch = chr(ord('a') + j)
                if curWord[i] == ch:
                    continue
                arr[i] = ch
                word = "".join(arr)
                if word in wordSet:
                    nextWords.append(word)
        return nextWords
      
    def dfs(self, beginWord, endWord, wordMap, distance, path, res):
        if beginWord == endWord:
            res.append(path[:])
            return 

        for nextWord in wordMap.get(beginWord, []):
            if distance[nextWord] == distance[beginWord] + 1:
                path.append(nextWord)
                self.dfs(nextWord, endWord, wordMap, distance, path, res)
                path.remove(nextWord)
        
        return
      