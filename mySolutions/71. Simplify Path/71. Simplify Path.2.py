from collections import deque

class Solution:
    def simplifyPath(self, path: str) -> str:
        
        stack = deque()
        curStr = ""

        for index in range(len(path)):
          ch = path[index]
          if ch != "/":
            curStr += ch
          elif ch == "/" and curStr == "":
            continue
          elif ch == "/" and curStr == "..":
            if len(stack) != 0:
              stack.pop()
            curStr = ""
          elif ch == "/" and curStr == ".":
            curStr = ""
          elif ch == "/":
            stack.append(curStr[:])
            curStr = ""
            
        # the last
        if curStr != ".." and curStr != "." and curStr != "":
          stack.append(curStr[:])
        elif curStr == ".." and len(stack) != 0:
          stack.pop()
        # print(stack)
        # print("/".join(stack))
        return "/" + "/".join(stack)