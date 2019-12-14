# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
        result = deque()
        self.dfs(root, 1, result)
        return list(result)
        
    def dfs(self, root, depth, result):
        if root == None:
            return 
        
        if len(result) < depth:
            result.appendleft([])
        result[- depth].append(root.val)
        
        self.dfs(root.left, depth + 1, result)
        self.dfs(root.right, depth + 1, result)
        
        return