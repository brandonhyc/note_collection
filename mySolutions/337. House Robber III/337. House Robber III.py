# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque

class Solution:
    def rob(self, root: TreeNode) -> int:
        
        # for each node
        # 0. include current root, not include the immediate child 
        # 1. exclude the current root, include the immediate children

        if root == None:
            return 0
 
        num1, num2 = self.dfs(root)

        return max(num1, num2) 

    def dfs(self, root):
        if root == None:
            # if None, both cases are 0
            return [0, 0]

        left0, left1 = self.dfs(root.left)
        right0, right1 = self.dfs(root.right)

        # if include immediate child, there are 3 cases, both left0 and right0, 0/1, 1/0, 
        sum0 = root.val + left1 + right1
        # if not include child, only one case
        sum1 = max(left0 + right0, left0 + right1, left1 + right0, left1 + right1)

        return [sum0, sum1]