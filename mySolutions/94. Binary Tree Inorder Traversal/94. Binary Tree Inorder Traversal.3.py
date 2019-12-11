# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        dummy = root
        stack = deque()
        result = []
        
        while root != None or len(stack) != 0:
          while root != None:
            stack.append(root)
            root = root.left
            
          root = stack.pop()
          result.append(root.val)
          
          root = root.right
        
        return result