from collections import deque

class Solution:
    def findOrder(self, tasks: int, prerequisites: List[List[int]]) -> List[int]:
      sortedOrder = []
  
      # init and build graph
      sources = deque()
      inDegree = {i: 0 for i in range(tasks)}
      graph = {i: [] for i in range(tasks)}

      for pre in prerequisites:
        parent, child = pre[1], pre[0]
        inDegree[child] += 1
        graph[parent].append(child)

      # put seed 
      for i in range(len(inDegree)):
        if inDegree[i] == 0:
          sources.append(i)

      # traverse
      while sources:
        source = sources.popleft()
        sortedOrder.append(source)

        for course in graph[source]:
          inDegree[course] -= 1
          if inDegree[course] == 0:
            sources.append(course)

      if len(sortedOrder) != tasks:
        return []
      # TODO: Write your code here
      return sortedOrder
