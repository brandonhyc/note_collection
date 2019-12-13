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
        
        dp[0] = nums[0]

        for i in range(len(nums)):
          
            sum1 = nums[]

            nums[i] = 
        
        