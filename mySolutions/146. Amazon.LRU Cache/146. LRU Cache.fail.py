# 16 / 18 test cases passed. 17 TLE
# Time: O(n) for GET operation, O(n) for PUT operation
from collections import deque

class LRUCache:

    map = {}
    queue = deque()
    capacity = 0
    
    def __init__(self, capacity: int):
        self.map = {}
        self.queue = deque()
        self.capacity = capacity
        
    def get(self, key: int) -> int:
        if key not in self.map:
            return -1;
        
        for i in range(len(self.queue)):
            item = self.queue.popleft()
            if item == key:
                continue
            self.queue.append(item)
        
        self.queue.append(key)
        return self.map[key]

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.get(key)
        else:
            self.queue.append(key)
        self.map[key] = value
        
        if len(self.queue) > self.capacity:
            item = self.queue.popleft()
            self.map.pop(item)
        

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)