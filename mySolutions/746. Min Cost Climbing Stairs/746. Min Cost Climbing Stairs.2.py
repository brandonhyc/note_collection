class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # for each index
         # 1. create a new set take one step if not excess, add the fee, recursively process the rest
         # 2. create a new set take two steps if not excess, add the fee, recursively process the rest
        # return the set with minmum sum
        
        if len(cost) <= 2:
            return 0

        dp = [sys.maxsize for i in range(len(cost))]

        for i in range(0, len(cost)):
            if i <= 1:
                dp[i] = cost[i]
                continue
            dp[i] = cost[i] + min(dp[i - 1], dp[i - 2])
            
        return min(dp[-1], dp[-2])

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        # for each index
         # 1. create a new set take one step if not excess, add the fee, recursively process the rest
         # 2. create a new set take two steps if not excess, add the fee, recursively process the rest
        # return the set with minmum sum
        
        dp = [sys.maxsize for i in range(len(cost))]

        return min(self.minCostRec(cost, 0, dp), self.minCostRec(cost, 1, dp)) 
    
    def minCostRec(self, cost, start, dp):
        
        if start >= len(cost):
            return 0

        if dp[start] != sys.maxsize:
            return dp[start]

        sum1 = cost[start] + self.minCostRec(cost, start + 1, dp)
        sum2 = cost[start] + self.minCostRec(cost, start + 2, dp)
        
        dp[start] = min(sum1, sum2)

        return dp[start]