class Solution:
    def rob(self, nums: List[int]) -> int:
        
        # dp [0 - lastHouse]
        # for house 0, we can only take it
        # for house 1, we can pick house 0 or house 1
        # for the last house, we should either take it or not
        
        if len(nums) == 0:
            return 0
        if len(nums) == 1:
            return nums[0]
        
        dp = [None for i in range(len(nums))]
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        for i in range(2, len(nums)):
          
            sum1 = dp[i - 1]
            sum2 = dp[i - 2] + nums[i]
            
            dp[i] = max(sum1, sum2)

        return dp[len(nums) - 1]