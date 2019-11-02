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
        def toBST(start, end) -> TreeNode:
            if end < start:
                return None
            
            mid = start + (end - start) // 2
            root = TreeNode(0)
            root.left = toBST(start, mid - 1)
            
            root.val = self.node.val
            self.node = self.node.next
            
            root.right = toBST(mid + 1, end)
            
            return root
        
        if head == None:
            return None
        
        self.node = head
        size = 0
        while head != None:
            head = head.next
            size += 1
        
        return toBST(0, size - 1)
        
    while(fast!=tail&&fast.next!=tail){
        fast = fast.next.next;
        slow = slow.next;
    }