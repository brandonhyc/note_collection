# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, K: int) -> List[int]:
        if root == None:
            return []
        
        nodeDistMap = {}
        res = []
        self.findTarget(root, target, nodeDistMap)
        
        # for key in nodeDistMap:
        #     print(key.val, nodeDistMap[key])
        self.dfs(root, nodeDistMap, nodeDistMap[root])
        
        for key in nodeDistMap:
            if nodeDistMap[key] == K:
                res.append(key.val)
        return res
        
    def dfs(self, root, nodeDistMap, parentDist):
        if root == None:
            return
        
        if root not in nodeDistMap:
            nodeDistMap[root] = parentDist + 1
        
        self.dfs(root.left, nodeDistMap, nodeDistMap[root])
        self.dfs(root.right, nodeDistMap, nodeDistMap[root])
        
    def findTarget(self, root, target, nodeDistMap):
        
        if root == None:
            return None
        
        if root == target:
            nodeDistMap[root] = 0
            return 0
        
        left = self.findTarget(root.left, target, nodeDistMap)
        right = self.findTarget(root.right, target, nodeDistMap)
        
        res = None
        
        if left != None:
            res = left
        elif right != None:
            res = right
            
        if res != None:
            nodeDistMap[root] = res + 1 
            return nodeDistMap[root]