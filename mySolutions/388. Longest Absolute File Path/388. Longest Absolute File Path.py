from collections import deque

class Solution:
    def lengthLongestPath(self, input: str) -> int:
        
      pathStack = deque()
      longest = 0 
      curLen = 0
      for block in input.split("\n"):
        spaceCount = 0
        word = ""
        for ch in block:
          if ch == "\t":
            spaceCount += 1
          else:
            word += ch
                
        while len(pathStack) > spaceCount:
          curLen -= len(pathStack.pop())
        
        if len(pathStack) > 0:
          word = "/" + word
        
        pathStack.append(word)
        curLen += len(word)
        if word.find(".") != -1 and word.find(".") != len(word) - 1:
          longest = max(longest, curLen)
      
      return longest