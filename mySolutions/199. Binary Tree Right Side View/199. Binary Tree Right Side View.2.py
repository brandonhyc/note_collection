# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root == None:
            return []
        result = []
        queue = deque()
        queue.append(root)
        
        while len(queue) != 0:
            size = len(queue)
            
            for i in range(size):
                root = queue.popleft()
                
                if root.left != None:
                    queue.append(root.left)
                if root.right != None:
                    queue.append(root.right)
                
                if i == size - 1:
                    result.append(root.val)
        
        return result
        