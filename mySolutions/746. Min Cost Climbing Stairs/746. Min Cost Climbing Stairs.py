class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        
        dp = [sys.maxsize for i in range(len(cost) + 1)]
        end = len(cost)
        
        for i in range(end + 1):
          if i - 1 < 0:
            dp[i] = 0
          elif i - 2 < 0:
            dp[i] = 0
          else:
            dp[i] = min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
        
        return dp[end]
          
        