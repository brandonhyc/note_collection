# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    count = 0
    
    def pathSum(self, root: TreeNode, sum: int) -> int:
        
        sums = []
        
        self.dfs(root, sum, sums)
        
        return self.count
    
    def dfs(self, root, target, sums):
        
        if root == None:
            return
        
        sums.append(0)
        
        for i in range(len(sums)):
            sums[i] += root.val
            
            if sums[i] == target:
                self.count += 1
        
        self.dfs(root.left, target, sums)
        self.dfs(root.right, target, sums)
        
        for i in range(len(sums)):
            sums[i] -= root.val
        sums.pop()
        