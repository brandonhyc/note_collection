# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    
    def minDepth(self, root: TreeNode) -> int:
        
        if root == None:
            return 0
        
        queue = deque()
        queue.append(root)

        depth = 0
        while len(queue) != 0:
            size = len(queue)
            depth += 1
            for i in range(size):
                root = queue.popleft()
                if root.left == None and root.right == None:
                    return depth
                if root.left != None:
                    queue.append(root.left)
                if root.right != None:
                    queue.append(root.right)
                