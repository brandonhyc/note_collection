# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque

class Codec:

    delimiter = ","
    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        result = []
        queue = deque()
        queue.append(root)
        
        while len(queue) != 0:
            size = len(queue)
            
            for i in range(size):
                root = queue.popleft()
                if root == None:
                    result.append("None")
                    continue
                result.append(str(root.val))
                queue.append(root.left)
                queue.append(root.right)
                
        return self.delimiter.join(result)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        dataList = data.split(",")
        queue = deque()
        
        if dataList[0] == "None":
            return None
        
        dummy = TreeNode(int(dataList[0]))
        queue.append(dummy)
        
        index = 1
        while len(queue) != 0:
            root = queue.popleft()
            
            if dataList[index] != "None":
                root.left = TreeNode(int(dataList[index]))
                queue.append(root.left)
            index += 1
            
            if dataList[index] != "None":
                root.right = TreeNode(int(dataList[index]))
                queue.append(root.right)
            index += 1
        
        return dummy
# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))