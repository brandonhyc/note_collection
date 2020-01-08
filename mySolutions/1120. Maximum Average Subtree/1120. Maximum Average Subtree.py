# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    maxAvg = 0
    
    def maximumAverageSubtree(self, root: TreeNode) -> float:
        
        self.dfs(root)
        
        return self.maxAvg
    
    def dfs(self, root):
        if root == None:
            return [0, 0]
        
        leftSum, leftNum = self.dfs(root.left)
        rightSum, rightNum = self.dfs(root.right)
        
        val = root.val + leftSum + rightSum
        num = 1 + leftNum + rightNum
        
        self.maxAvg = max(val / num, self.maxAvg)
        
        return [val, num]