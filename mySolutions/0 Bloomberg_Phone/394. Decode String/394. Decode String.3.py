from collections import deque

class Solution:
    def decodeString(self, string: str) -> str:
        stack = deque()
        num = 0
        for i in range(len(string)):
            ch = string[i]
            if ch.isnumeric():
                num = num * 10 + int(ch)
            elif ch == '[':
                stack.append(num)
                num = 0
            elif ch == ']':
                s = ""
                while not str(stack[len(stack) - 1]).isnumeric():
                    s = stack.pop() + s
                num2 = stack.pop()
                stack.append(num2 * s)
            else:
                stack.append(ch)
        res = ""
        while len(stack) != 0:
            res = stack.pop() + res
            
        return res