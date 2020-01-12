# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

from collections import deque

class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        if len(lists) == 0:
            return None
        
        que = deque()
        for lis in lists:
            que.append(lis)
        while len(que) > 1:
            l1 = que.pop()
            l2 = que.pop()
            l3 = self.mergeTwoLists(l1, l2)
            que.append(l3)
            
        return que[0]
        
        
        
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(-1)
        l3 = dummy
        
        while l1 != None and l2 != None:
            if l1.val < l2.val:
                l3.next = l1
                l1 = l1.next
                l3 = l3.next
            else:
                l3.next = l2
                l2 = l2.next
                l3 = l3.next
        
        # finish iterating l1
        if l1 == None:
            l3.next = l2
        else:
            l3.next = l1
        
        
        return dummy.next