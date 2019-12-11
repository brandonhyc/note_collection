# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:

        if root == None:
            return []
        dummy = root
        queue = deque()        
        result = []
        
        queue.append(root)
        
        while len(queue) != 0:
            size = len(queue)
            level = []
            for i in range(size):
                root = queue.popleft()
                level.append(root.val)
                if root.left != None:
                    queue.append(root.left)
                if root.right != None:
                    queue.append(root.right)
            
            result.append(level)
        return result