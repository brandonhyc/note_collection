# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if root == None:
            return True

        return self.isTwoSymmetric(root.left, root.right)
    
    def isTwoSymmetric(self, left, right):
        if left == None and right == None:
            return True
        if left == None or right == None or left.val != right.val:
            return False
        res1 = self.isTwoSymmetric(left.left, right.right)
        res2 = self.isTwoSymmetric(left.right, right.left)
        return res1 and res2
    