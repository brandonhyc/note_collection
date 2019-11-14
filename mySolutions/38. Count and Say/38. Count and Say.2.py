class Solution:
    def countAndSay(self, n: int) -> str:
      if n <= 1:
        return str(1)
      
      last = self.countAndSay(n - 1)
      
      res = ""
      
      i = 0
      while i < len(last):
        count = 1
        while i + 1 < len(last) and last[i] == last[i + 1]:
          count += 1
          i += 1
        res += str(count) + str(last[i])
        i += 1
      
      return res