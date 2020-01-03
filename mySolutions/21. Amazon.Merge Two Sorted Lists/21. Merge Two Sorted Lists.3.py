# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

import sys

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        dummy = ListNode(0)
        l0 = dummy

        while l1 != None or l2 != None:
            n1 = l1.val if l1 != None else sys.maxsize
            n2 = l2.val if l2 != None else sys.maxsize

            if n1 <= n2:
                l0.next = l1
                l1 = l1.next
            else:
                l0.next = l2
                l2 = l2.next
            l0 = l0.next

        return dummy.next
                