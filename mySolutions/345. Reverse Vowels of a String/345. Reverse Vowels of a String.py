class Solution:
    def reverseVowels(self, s: str) -> str:
      vowels = "aeiouAEIOU"
      arr = list(s)
      left = 0
      right = len(arr) - 1

      while left < right:
        while left < right and arr[left] not in vowels:
          left += 1
        while left < right and arr[right] not in vowels:
          right -= 1

        self.reverse(arr, left, right)
        left += 1
        right -= 1
      return "".join(arr)
    
    def reverse(self, arr, left, right):
      temp = arr[left]
      arr[left] = arr[right]
      arr[right] = temp
          