class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> List[List[int]]:
        if len(nums) == 0:
            return 0
        dp = [-1 for i in range(target + 1)]
        self.countSum(nums, target, dp)
        return dp[target]

    def countSum(self, nums, target, dp):
        if target < 0:
            return 0
        
        if dp[target] != -1:
            return dp[target]
        
        if target == 0:
            return 1

        res = 0
        
        for num in nums:
            res += self.countSum(nums, target - num, dp)
        
        dp[target] = res
        return dp[target]