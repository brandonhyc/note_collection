class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        
        if len(nums) == 0:
            return 0
        
        dp = [-1 for i in range(len(nums))]
        curSum = nums[0]
        dp[0] = curSum
        
        for i in range(1, len(nums)):
            curSum = curSum + nums[i] if curSum > 0 else nums[i]
            dp[i] = max(dp[i - 1], curSum)    
            
        return dp[-1]