from collections import deque
class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
      # bfs
      queue = deque()
      queue.append(beginWord)
      wordMap = {}
      
      while queue:
        size = len(queue)

        for i in range(size):
          curWord = queue.popleft()
          
          wordList.remove(curWord)
          if curWord == endWord:
            break;
            
          nextWords = []
          for i in range(len(curWord)):
            arr = list(curWord)

            for j in range(26):
              ch = chr(ord('a') + j)
              if curWord[i] == ch:
                continue
              arr[i] = ch
              word = "".join(arr)
              if word in wordList and word not in wordMap:
                wordMap[word] = []
                nextWords.append(word)
                queue.append(word)
                print("wordList", wordList, "nextWords", nextWords)
          
          wordMap[curWord] = nextWords
          print ("wordMap", wordMap)
      res = []
      self.dfs(beginWord, endWord, wordMap, [], res)
      
      return res
      
    def dfs(self, beginWord, endWord, wordMap, path, res):
      if beginWord == endWord:
        path.append(endWord)
        res.append(path[:])
        return 
      
      for nextWord in wordMap[beginWord]:
        path.append(beginWord)
        self.dfs(nextWord, endWord, wordMap, path, res)
        path.remove(beginWord)
      
      return
      