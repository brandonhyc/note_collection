# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        
        stack = deque()
        dummy = root
        result = []
        
        while root != None or len(stack) != 0:
            while root != None:
                result.append(root.val)
                stack.append(root)
                root = root.right

            root = stack.pop()
            root = root.left
        result.reverse()
        return result