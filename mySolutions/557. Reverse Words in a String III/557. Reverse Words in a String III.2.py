class Solution:
    def reverseWords(self, s: str) -> str:
      arr = list(s)
      left = 0
      
      while left <= len(arr) - 1:
        right = left
        while right <= len(arr) - 1 and arr[right] != ' ':
          right += 1
          
        self.reverse(arr, left, right - 1)
        left = right + 1
      
      return "".join(arr)  
        
        
    def reverse(self, arr, left, right):
      while left < right:
        temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left += 1
        right -= 1