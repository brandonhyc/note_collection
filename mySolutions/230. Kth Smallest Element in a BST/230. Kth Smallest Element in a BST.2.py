# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        
        stack = deque()
        
        while root != None or len(stack) != 0:
            
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            k -= 1
            if k == 0:
                return root.val
            root = root.right
            
        return -1
                