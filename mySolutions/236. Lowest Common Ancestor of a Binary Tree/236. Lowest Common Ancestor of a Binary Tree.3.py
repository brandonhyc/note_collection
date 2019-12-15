# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':

        return self.dfs(root, p, q)
        
        
    def dfs(self, root, p, q):
        if root == None:
            return None
        if root.val == p.val or root.val == q.val:
            return root
        
        left = self.dfs(root.left, p, q)
        right = self.dfs(root.right, p, q)
        
        if left != None and right != None:
            return root
        if left != None:
            return left
        if right != None:
            return right
        
        return None
        