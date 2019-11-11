import sys

class Solution:
    def increasingTriplet(self, nums: List[int]) -> bool:
      if len(nums) <= 2:
        return False
      
      min1 = sys.maxsize
      min2 = sys.maxsize

      for num in nums:
        if min1 >= num:
          min1 = num
        elif min2 >= num:
          min2 = num
        else:
          return True
      
      return False