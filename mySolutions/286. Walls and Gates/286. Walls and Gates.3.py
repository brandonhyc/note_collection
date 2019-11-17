import numpy as np
from collections import deque 

class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        
        queueX = deque()
        queueY = deque()
        
        for x in range(len(rooms)):
          for y in range(len(rooms[0])):
            if rooms[x][y] == 0:
              queueX.append(x)
              queueY.append(y)
        
        distance = 0
        while queueX:
          size = len(queueX)
          distance += 1
          # print (np.matrix(rooms), "distance:", distance)
          # print ("queueX", queueX)
          # print ("queueY", queueY)
          
          for j in range(size):
            x = queueX.popleft()
            y = queueY.popleft()
            dy = [1, 0, -1, 0]
            dx = [0, 1, 0, -1]
            
            for i in range(4):
              if x + dx[i] < 0 or x + dx[i] > len(rooms) - 1 or \
              y + dy[i] < 0 or y + dy[i] > len(rooms[0]) - 1 or \
              rooms[x + dx[i]][y + dy[i]] == -1 or \
              rooms[x + dx[i]][y + dy[i]] <= distance:
                continue
              queueX.append(x + dx[i])
              queueY.append(y + dy[i])
              rooms[x + dx[i]][y + dy[i]] = distance
        
        return rooms