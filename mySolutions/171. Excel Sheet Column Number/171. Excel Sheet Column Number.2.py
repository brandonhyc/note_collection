class Solution:
    def titleToNumber(self, s: str) -> int:
        res = 0
        for i in range(len(s)):
          res *= 26
          ch = s[i]
          res += (ord(ch) - ord("A") + 1)
          
        return res
          