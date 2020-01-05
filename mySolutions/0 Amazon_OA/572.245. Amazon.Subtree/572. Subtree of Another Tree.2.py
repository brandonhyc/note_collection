# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSubtree(self, s: TreeNode, t: TreeNode) -> bool:
        if self.isSameTree(s, t):
            return True
        if s == None:
            return False
        
        return self.isSubtree(s.left, t) or self.isSubtree(s.right, t)
        
    def isSameTree(self, s, t):
        if s == None and t == None:
            return True
        if s == None or t == None:
            return False
        
        return s.val == t.val and self.isSameTree(s.left, t.left) and self.isSameTree(s.right, t.right)