# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        result = []
        
        if root == None:
            return result
        
        self.search(root, "", result)
        
        return result
    
    def search(self, root, res, result):
        if root == None:
            return
        
        res = res[:] + str(root.val)
        
        if root.left == None and root.right == None:
            result.append(res)
        
        res = res + "->"
        
        self.search(root.left, res, result)
        self.search(root.right, res, result)
