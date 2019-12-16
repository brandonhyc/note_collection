# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 这道题容易想歪，其实就是老老实实 traverse 就足够了。总体来说没有再做的必要了

from collections import deque

class Solution:
    
    smallest = sys.maxsize
    second = sys.maxsize
    
    def findSecondMinimumValue(self, root: TreeNode) -> int:
        if root == None:
            return -1
        
        self.smallest = root.val
        self.dfs(root)
        
        return self.second if self.second != sys.maxsize else -1
    
    def dfs(self, root):
        if root == None:
            return 
        
        self.dfs(root.left)
        self.dfs(root.right)
        
        if root.val != self.smallest:
            self.second = min(root.val, self.second)
            