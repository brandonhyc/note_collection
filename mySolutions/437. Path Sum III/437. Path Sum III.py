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

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> int:
        
        if root == None:
            return 0
        
        count1 = self.pathSum(root.left, sum)
        count2 = self.pathSum(root.right, sum)
        
        count3 = self.countPathSumFrom(root, sum)
        return count1 + count2 + count3
    
    def countPathSumFrom(self, root, sum):
        
        if root == None:
            return 0
        
        sum -= root.val
        
        count1 = 0
        count2 = 0
        count3 = 0
        
        if sum == 0:
            count1 += 1
        
        count2 = self.countPathSumFrom(root.left, sum)
        count3 = self.countPathSumFrom(root.right, sum)
        
        return count1 + count2 + count3
        
        
