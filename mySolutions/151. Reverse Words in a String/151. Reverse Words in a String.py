class Solution:
  def reverseWords(self, s: str) -> str:
    arr = list(s)
    
    # reverse whole string
    self.reverse(arr, 0, len(arr) - 1)
    resultArr = []
    
    left = 0
    while left <= len(s) - 1:
      while left <= len(s) - 1 and arr[left] == ' ':
        left += 1 # left is at wordStart / left is at len(s) out of boundary
      
      right = left
      while right <= len(s) - 1 and arr[right] != ' ':
        right += 1 # right is at wordEnd + 1 (space) / right is at len(s) out of boundary

      self.reverse(arr, left, right - 1)
      word = "".join(arr[left: right])
      if word != "": 
        resultArr.append(word)
      left = right
      
    return " ".join(resultArr)
      
  
  def reverse(self, arr, left, right):
    while left < right:
      temp = arr[left]
      arr[left] = arr[right]
      arr[right] = temp
      
      left += 1
      right -= 1
    