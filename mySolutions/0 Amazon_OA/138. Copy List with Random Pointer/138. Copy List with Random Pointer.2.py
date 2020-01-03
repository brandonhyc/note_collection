"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""
class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head == None:
            return head

        oldNewMap = {}

        root = head
        oldNewMap[root] = Node(root.val)

        while root != None:
            if root.next != None and root.next not in oldNewMap:
                oldNewMap[root.next] = Node(root.next.val)
            if root.random != None and root.random not in oldNewMap:
                oldNewMap[root.random] = Node(root.random.val)

            oldNewMap[root].val = root.val
            oldNewMap[root].next = oldNewMap[root.next] if root.next != None else None
            oldNewMap[root].random = oldNewMap[root.random] if root.random != None else None

            root = root.next
        return oldNewMap[head]