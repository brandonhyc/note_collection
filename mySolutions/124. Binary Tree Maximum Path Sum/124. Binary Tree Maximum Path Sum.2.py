# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    maxSum = -sys.maxsize - 1 
    
    def maxPathSum(self, root: TreeNode) -> int:
        
        self.dfs(root)    
        
        return self.maxSum
      
    def dfs(self, root):
        
        if root == None:
          return 0
        
        sumLeft = self.dfs(root.left)
        sumRight = self.dfs(root.right)

        # max sum can be 
        # 1. at current root, left + root + right
        # 2. not at current root, pass the current value (positive) to upper level
        sumOfU = root.val + sumLeft + sumRight
        self.maxSum = max(sumOfU, self.maxSum)

        sumToPass = root.val + max(sumLeft, sumRight)
        self.maxSum = max(sumToPass, self.maxSum)
        return max(sumToPass, 0)