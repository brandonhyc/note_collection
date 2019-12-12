# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    total = 0
    
    def sumNumbers(self, root: TreeNode) -> int:
        path = ""
        self.dfs(root, path)
        return self.total 
        
    def dfs(self, root, path):
        if root == None:
            return 
        
        nextPath = path[:] + str(root.val)
        
        if root.left == None and root.right == None:
            self.total += int(nextPath)
        
        self.dfs(root.left, nextPath)
        self.dfs(root.right, nextPath)