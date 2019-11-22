import sys
from collections import deque

class MinStack:
    
    stack = deque();
    minValue = sys.maxsize;
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = deque()
        self.minValue = sys.maxsize;
        
    def push(self, x: int) -> None:
        self.stack.append(x)
        self.minValue = min(x, self.minValue)
        
    def pop(self) -> None:
        popValue = self.stack.pop()
        # print(self.stack, popValue)
        if popValue != self.minValue:
          return popValue
        
        self.minValue = sys.maxsize
        tempStack = deque()
        
        while len(self.stack) > 0:
          value = self.stack.pop()
          self.minValue = min(value, self.minValue)
          tempStack.append(value)
        
        while len(tempStack) > 0:
          self.stack.append(tempStack.pop())
        return popValue
          

    def top(self) -> int:
        return self.stack[-1] 

    def getMin(self) -> int:
        return self.minValue


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()