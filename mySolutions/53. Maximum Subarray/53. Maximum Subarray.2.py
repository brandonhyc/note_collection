class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        dp = [0 for i in range(len(nums))]
        dp[0] = nums[0]
        curSum = max(0, nums[0])
        
        for i in range(1, len(nums)):
            if curSum + nums[i] <= 0:
                curSum = 0
                dp[i] = max(nums[i], dp[i - 1])
            else:
                curSum += nums[i]
                dp[i] = max(curSum, dp[i - 1])
            # print(dp, curSum)
        
        return dp[-1]