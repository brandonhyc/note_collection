from collections import deque
class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = deque()
        
        for element in tokens:
          if element not in "+-*/":
            stack.append(element)
          else:
            el1 = int(stack.pop())
            el2 = int(stack.pop())
            op = element
            
            res = 0
            if op == "+":
              res = el2 + el1
            elif op == "-":
              res = el2 - el1
            elif op == "/":
              res = int(el2 / el1)
            elif op == "*":
              res = el2 * el1
            else:
              raise "error while parsing input"
            
            # print("el2", el2, "el1", el1, "op", op, "res", res)
            stack.append(res)
            
        return stack.pop()
        