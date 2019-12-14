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
        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        dp = [None for i in range(len(nums))]

        nums1 = nums[:]
        nums2 = nums[:]
        nums1[1] = 0
        nums2[0] = 0

        sum1 = self.robFrom(nums1, dp)
        # print(sum1, dp)
        sum2 = self.robFrom(nums2, dp)
        # print(sum2, dp)
        

        return max(sum1, sum2)

    def robFrom(start, nums, dp):
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for index in range(2, len(nums) - 1):
          
            sum1 = dp[index - 1]
            sum2 = dp[index - 2] + nums[index]
            
            dp[index] = max(sum1, sum2)
        
        index = len(nums) - 1
        
        if nums[0] != 0:
            return dp[index - 1]
        else:
            sum1 = dp[index - 1]
            sum2 = dp[index - 2] + nums[index]
            return max(sum1, sum2)