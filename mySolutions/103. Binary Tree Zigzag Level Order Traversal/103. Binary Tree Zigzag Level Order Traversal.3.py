# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if root == None:
            return []
        
        result = []
        queue = deque()
        queue.append(root)
        fromLeft = False
        
        while len(queue) != 0:
            size = len(queue)
            level = deque()
            result.append(level)
            fromLeft = not fromLeft
            
            for i in range(size):
                root = queue.popleft()
                
                if root.left != None:
                    queue.append(root.left)
                if root.right != None:
                    queue.append(root.right)
                
                if fromLeft:
                    level.append(root.val)
                else:
                    level.appendleft(root.val)
        
        return result