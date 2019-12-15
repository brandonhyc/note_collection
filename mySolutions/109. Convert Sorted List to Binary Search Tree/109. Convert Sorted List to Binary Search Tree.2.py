# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        return self.dfs(head, None)
    
    def dfs(self, start, end):
        if start == end:
            return None
        
        dummy = TreeNode(-1)
        dummy.next = start
        
        slow = dummy
        fast = dummy
        
        while fast != end and fast.next != end:
            slow = slow.next
            fast = fast.next.next
        
        mid = slow
        root = TreeNode(mid.val)
        root.left = self.dfs(start, mid)
        root.right = self.dfs(mid.next, end)
        
        return root