class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        end = len(s) - 1
        
        # remove suffix space
        while end >= 0 and s[end] == ' ':# missing edge case 6
          end -= 1
          
        # read the word
        start = end
        while start >= 0 and s[start] != ' ':
          start -= 1
        
        
        return end - start