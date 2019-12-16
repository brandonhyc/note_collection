# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        
        if root == None :
            return True
        stack = deque()
        last = None
        
        while root != None or len(stack) != 0:
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if last != None and last.val >= root.val:
                return False
                
            last = root
            root = root.right
        
        
        return True