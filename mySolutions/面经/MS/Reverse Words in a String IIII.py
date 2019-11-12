2: reverse words in a string, with puncs at same position. 
eg. "Hello world, how are you?" -> "you are, how world Hello?"

import string
class Solution:
    def reverseWords(self, s: str) -> str:
        
        arr = self.convertToArray(s)
        self.reverse(arr, 0, len(arr) - 1)
        return self.convertToString(arr)
        
        
    def convertToString(self,arr):
        res = ""
        prefix = " "

        for s in arr:
            if s not in string.punctuation:
                res += prefix
            res += s
        
        return res.strip()
            

    def convertToArray(self, s: str):
        res = []
        arr = list(s)

        left = 0
        while left <= len(s) - 1:
                        
            while left <= len(s) - 1 and arr[left] == ' ': # skip all space
                left += 1
            right = left + 1
            while right <= len(s) - 1 and arr[right].isalnum():
                right += 1
            
            block = arr[left : right]
            res.append("".join(block))
            left = right
        return res
    
    def reverse(self, arr, left, right):
        while left < right:
            while left < right and arr[left] in string.punctuation:
                left += 1
            while left < right and arr[right] in string.punctuation:
                right -= 1
            
            if left < right:
                temp = arr[left]
                arr[left] = arr[right]
                arr[right] = temp
                left += 1
                right -= 1
    