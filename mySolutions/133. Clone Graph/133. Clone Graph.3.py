from collections import deque

"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        map = {}
        queue = deque()
        
        queue.append(node)
        
        while queue:
          origin = queue.popleft()
          
          if origin not in map:
            map[origin] = Node(node.val, [])
            
          clone = map[origin]
          
          for neighbor in origin.neighbors:
            if neighbor not in map:
              map[neighbor] = Node(neighbor.val, [])
              queue.append(neighbor)
              
            clone.neighbors.append(map[neighbor])
        
        return map[node]