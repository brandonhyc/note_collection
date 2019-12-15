# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.dfs(root, p, q)
    
    def dfs(self, root, left, right):
        if root == None:
            raise "error"
        
        if root.val == left.val or root.val == right.val:
            return root
        
        if left.val < root.val and root.val < right.val:
            return root
        
        if right.val < root.val and root.val < left.val:
            return root
        
        if root.val < left.val and root.val < right.val:
            return self.dfs(root.right, left, right)
        
        if left.val < root.val and right.val < root.val:
            return self.dfs(root.left, left, right)
        
        