from collections import deque
class MyStack:

    inputQueue = deque()
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.inputQueue = deque()

    def push(self, x: int) -> None:
        """
        Push element x onto stack.
        """
        str.isnumeric
        self.inputQueue.append(x)

    def pop(self) -> int:
        """
        Removes the element on top of the stack and returns that element.
        """
        size = len(self.inputQueue)
        for i in range(size - 1):
          self.inputQueue.append(self.inputQueue.popleft())
        
        popValue = self.inputQueue.popleft()
        
        return popValue
        

    def top(self) -> int:
        """
        Get the top element.
        """
        return self.inputQueue[len(self.inputQueue) - 1]

    def empty(self) -> bool:
        """
        Returns whether the stack is empty.
        """
        return len(self.inputQueue) == 0


# Your MyStack object will be instantiated and called as such:
# obj = MyStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.empty()