class Solution:
    def reverseStr(self, s: str, k: int) -> str:
      
      arr = list(s)
      
      i = 0
      while i < len(s) + 1 - k:
        left = i
        right = i + k - 1
        self.reverse(arr, left, right)
        i += 2 * k
        
      self.reverse(arr, i, len(s) - 1)
    
      return "".join(arr)
        
    def reverse(self, s, left, right):
      while (left < right):
        temp = s[left]
        s[left] = s[right]
        s[right] = temp
        
        left += 1
        right -= 1