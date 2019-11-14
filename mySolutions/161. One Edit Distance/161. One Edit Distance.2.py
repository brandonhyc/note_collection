class Solution:
    def isOneEditDistance(self, s: str, t: str) -> bool:
      
      sShift = 0 if len(s) < len(t) else 1
      tShift = 0 if len(s) > len(t) else 1
        
      for i in range(max(len(s), len(t))):
        if i > min(len(s) - 1, len(t) - 1) or s[i] != t[i]:
          return s[i + sShift : ] == t[i + tShift : ]
        
      return False
