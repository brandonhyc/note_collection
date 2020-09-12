
# BFS/DFS

## bidirectional bfs


## tracing issue
Need to make sure the same candidate won't be added again

127. Word Ladder
     ```java
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
    ```        