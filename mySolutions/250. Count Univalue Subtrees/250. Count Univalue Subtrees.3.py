# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    count = 0
    def countUnivalSubtrees(self, root: TreeNode) -> int:
        self.dfs(root)
        return self.count
      
    def dfs(self, root):
        # return True if subtree is univalue
        if root == None:
          return True
        
        isLeftUniv = self.dfs(root.left)
        isRightUniv = self.dfs(root.right)
        
        if not isLeftUniv or not isRightUniv:
          return False
        
        if root.left != None and root.left.val != root.val:
          return False
        if root.right != None and root.right.val != root.val:
          return False
        
        # if left tree and right tree are univalue, also current tree is univalue 
        self.count += 1
        
        return True
        