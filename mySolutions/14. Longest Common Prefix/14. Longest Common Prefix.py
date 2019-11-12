class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
      if len(strs) == 0:
        return ""
      
      start = 0
      shortest = None
      
      for str in strs:
        if shortest == None or len(shortest) > len(str):
          shortest = str
      for end in range(0, len(shortest)):
        
        for str in strs:
          if str[end] != strs[0][end]:
            return strs[0][0: end]
          
      return strs[0][0: len(shortest)]