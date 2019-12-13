# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def findLeaves(self, root: TreeNode) -> List[List[int]]:
        
        result = []
        
        self.dfs(root, result)
        
        return result
      
    def dfs(self, root, result):
        
        if root == None:
            return -1
          
        height1 = self.dfs(root.left, result)
        height2 = self.dfs(root.right, result) 
        
        rootHeight = 1 + max(height1, height2)
        
        if rootHeight >= len(result):
            result.append([])
        result[rootHeight].append(root.val)
        
        return rootHeight