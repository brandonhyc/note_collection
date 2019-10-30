from collections import deque

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        
      # init
      inDegree = {i: 0 for i in range(numCourses)}
      graph = {i: [] for i in range(numCourses)}

      # build graph
      for pre in prerequisites:
        parent, child = pre[0], pre[1]
        inDegree[child] += 1
        graph[parent].append(child)

      # put sources
      sources = deque()
      for i in range(len(inDegree)):
        if inDegree[i] == 0:
          sources.append(i)

      # traverse
      while sources:
        source = graph[sources.popleft()];

        for course in source:
          inDegree[course] -= 1
          if inDegree[course] == 0:
            sources.append(course)

      for i in range(len(inDegree)):
        if inDegree[i] != 0:
          return False

      return True