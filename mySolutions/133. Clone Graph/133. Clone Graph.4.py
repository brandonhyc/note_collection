"""
# Definition for a Node.
class Node:
    def __init__(self, val, neighbors):
        self.val = val
        self.neighbors = neighbors
"""
class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        oldNewMap = {}
        self.dfs(node, oldNewMap)
        return oldNewMap[node]

    def dfs(self, root, oldNewMap):
        if root not in oldNewMap:
            oldNewMap[root] = Node(root.val, [])
        
        for oldNei in root.neighbors:
            if oldNei not in oldNewMap:
                self.dfs(oldNei, oldNewMap)

            newNei = oldNewMap[oldNei]
            oldNewMap[root].neighbors.append(newNei)