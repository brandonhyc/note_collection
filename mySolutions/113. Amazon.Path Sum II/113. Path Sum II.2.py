# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        
        result = []
        path = []
        
        self.dfs(root, sum, path, result)
        
        return result
    
    def dfs(self, root, sum, path, result):
        if root == None:
            return
        
        path.append(root.val)
        sum -= root.val
        
        if root.left == None and root.right == None:
            if sum == 0:
                result.append(list(path))
        
        else:
            self.dfs(root.left, sum, path, result)
            self.dfs(root.right, sum, path, result)
        
        path.pop()
        sum += root.val