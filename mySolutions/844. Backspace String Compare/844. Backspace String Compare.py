# Two Pointer Time Complexity O(n), Space Complexity: O(1)
class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
      
      ptrS = len(S)
      ptrT = len(T)
      
      while ptrS >= 0 or ptrT >= 0:
        
        ptrS = self.getNext(S, ptrS)
        ptrT = self.getNext(T, ptrT)
        
        chS = S[ptrS] if ptrS >= 0 else ''
        chT = T[ptrT] if ptrT >= 0 else ''
              
        if chS != chT: 
          return False
        
      return True
    
    def getNext(self, s: str, ptrS: int):
      count = 1
      while ptrS >= 0 and (count > 0 or s[ptrS] == '#'):
        ptrS -= 1
        if ptrS < 0:
          return -1
        elif s[ptrS] == '#':
          count += 1
        else:
          count -= 1
       
      if count > 0: 
        return -1
      
      return ptrS
       
      