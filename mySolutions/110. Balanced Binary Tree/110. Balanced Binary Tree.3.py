# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root == None:
            return True
        
        height1 = self.getHeight(root.left)
        height2 = self.getHeight(root.right)
        
        if abs(height1 - height2) > 1:
            return False
        
        if not self.isBalanced(root.left):
            return False
        
        if not self.isBalanced(root.right):
            return False
        
        return True 
    
    def getHeight(self, root):
        if root == None:
            return 0
        
        height1 = self.getHeight(root.left)
        height2 = self.getHeight(root.right)
        
        return 1 + max(height1, height2)