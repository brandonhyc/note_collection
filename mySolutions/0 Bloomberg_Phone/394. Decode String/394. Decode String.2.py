from collections import deque

class Solution:
    def decodeString(self, s: str) -> str:
        stack = deque()
        
        for ch in s:
          if ch != "]":
            stack.append(ch)
          
          else:
            # ch == ]
            word = ""
            nextCh = stack.pop()
            
            while nextCh != "[":
              word = nextCh + word
              nextCh = stack.pop()
            
            numStr = ""
            while len(stack) > 0 and stack[len(stack) - 1].isdigit():
              numStr = stack.pop() + numStr
            
            num = int(numStr)
            stack.append(word * num)
      
        return "".join(stack) if len(stack) > 0 else ""