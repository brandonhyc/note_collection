class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        preSums = {}
        curSum = 0
        count = 0

        preSums[0] = 1 # if the first num is a match, count = 1
        for i in range(len(nums)):
            curSum += nums[i]
            
            # preSum = curSum - k
            if curSum - k in preSums:
                count += preSums[curSum - k]
                
            if curSum not in preSums:
                preSums[curSum] = 0 # from 0 to i (including i)
            preSums[curSum] += 1

        return count