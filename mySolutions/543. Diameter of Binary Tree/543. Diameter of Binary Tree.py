# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    maxDiameter = 0
    
    def diameterOfBinaryTree(self, root: TreeNode) -> int:

        self.getDepth(root)

        return self.maxDiameter

    def getDepth(self, root):
        if root == None:
            return 0
        
        left = self.getDepth(root.left)
        right = self.getDepth(root.right)
        
        self.maxDiameter = max(left + right, self.maxDiameter)
        
        return 1 + max(left, right)