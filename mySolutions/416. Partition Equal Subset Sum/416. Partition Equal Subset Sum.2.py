# import numpy as np

class Solution:
    def canPartition(self, nums: List[int]) -> bool:
      if sum(nums) % 2 != 0:
        return False
      
      s =  sum(nums) // 2

      dp = [[False for i in range(s + 1)] for j in range(len(nums))]
      # dp[subset index][targetSum]
      
      for i in range(0, len(nums)):
        dp[i][0] = True
      
      for j in range(1, s + 1):
        dp[0][j] = nums[0] == j

      for i in range(1, len(nums)):
        for target in range(1, s + 1):
          if dp[i - 1][target]:
            dp[i][target] = True
          elif target - nums[i] >= 0:
            dp[i][target] = dp[i - 1][target - nums[i]]
            
      # print(np.matrix(dp))
      return dp[len(nums) - 1][s]
            