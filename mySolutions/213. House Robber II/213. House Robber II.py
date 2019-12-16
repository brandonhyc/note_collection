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
<<<<<<< HEAD
=======
        if len(nums) == 2:
            return max(nums[0], nums[1])
>>>>>>> 58fa8e1bb41ca3a1dfa7b8d7eb3e687cae69154f
        
        dp = [None for i in range(len(nums))]

        nums1 = nums[:]
        nums2 = nums[:]
        nums1[1] = 0
        nums2[0] = 0

        sum1 = self.robFrom(nums1, dp)
<<<<<<< HEAD
        sum2 = self.robFrom(nums2, dp)

        print("sum1," sum1, nums1)
        print("sum2, ", sum2, nums2)
=======
        # print(sum1, dp)
        sum2 = self.robFrom(nums2, dp)
        # print(sum2, dp)
        

>>>>>>> 58fa8e1bb41ca3a1dfa7b8d7eb3e687cae69154f
        return max(sum1, sum2)

    def robFrom(start, nums, dp):
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
<<<<<<< HEAD
        index = 0
=======
>>>>>>> 58fa8e1bb41ca3a1dfa7b8d7eb3e687cae69154f
        for index in range(2, len(nums) - 1):
          
            sum1 = dp[index - 1]
            sum2 = dp[index - 2] + nums[index]
            
            dp[index] = max(sum1, sum2)
        
<<<<<<< HEAD
        index += 1
        if nums[0] != 0:
            return dp[index - 2]
=======
        index = len(nums) - 1
        
        if nums[0] != 0:
            return dp[index - 1]
>>>>>>> 58fa8e1bb41ca3a1dfa7b8d7eb3e687cae69154f
        else:
            sum1 = dp[index - 1]
            sum2 = dp[index - 2] + nums[index]
            return max(sum1, sum2)