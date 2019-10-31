import sys
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        if root == None: 
            return True
        
        stack = []
        pre =  None
        
        while stack or root != None:
            while root != None:
                stack.append(root)
                root = root.left
            
            root = stack.pop()
            if pre == None:
                pre = root
            elif pre.val < root.val:
                pre = root
            else:
                return False
            root = root.right
                
        return True
        
        
        
        