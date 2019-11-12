class Solution:
    def reverseWords(self, s: List[str]) -> None:
        """
        Do not return anything, modify s in-place instead.
        """
        self.reverse(s, 0, len(s) - 1)
        
        left = 0
        while left <= len(s) - 1:
          right = left
          while right <= len(s) - 1 and s[right] != ' ': right += 1
          # right at ' ' or right out of boundary
          self.reverse(s, left, right - 1)
          
          left = right + 1
      
      
    def reverse(self, arr, left, right):
      while left < right:
        temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left += 1
        right -= 1