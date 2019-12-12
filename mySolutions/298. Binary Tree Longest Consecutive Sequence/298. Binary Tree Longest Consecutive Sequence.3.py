# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    longest = 0
    def longestConsecutive(self, root: TreeNode) -> int:
        if root == None:
            return self.longest
        pathLen = 1
        self.dfs(root, pathLen)
        return self.longest
    
    def dfs(self, root, pathLen):
        
        len1 = 1
        len2 = 1
        
        if root.left != None:
            if root.val + 1 == root.left.val:
                len1 = pathLen + 1 
            self.dfs(root.left, len1)
        if root.right != None:
            if root.val + 1 == root.right.val:
                len2 = pathLen + 1
            self.dfs(root.right, len2)
        
        len1 = max(len1, len2)
        self.longest = max(len1, self.longest)
        