class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        map = {}
        maxLen = 0
        
        for num in nums:
          if num in map:
            continue
          
          leftMost = map.get(num - 1, 0)
          rightMost = map.get(num + 1, 0)
          
          sum = 1 + leftMost + rightMost
          
          if num - leftMost in map: map[num - leftMost] = sum
          if num + rightMost in map: map[num + rightMost] = sum
          
          map[num] = sum
          
        for key in map:
          maxLen = max(map[key], maxLen)
          
        return maxLen