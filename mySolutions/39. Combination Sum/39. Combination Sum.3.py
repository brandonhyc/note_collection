class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        if len(nums) == 0:
            return []
        
        start = 0
        curSum = []
        res = []
        
        self.dfs(nums, start, target, curSum, res)
        return res    
        
    def dfs(self, nums, start, target, curSum, res):
        # print(curSum, target)
        if target < 0:
            return 
        
        if target == 0:
            res.append(curSum[:])
            return
        
        for i in range(start, len(nums)):
            curSum.append(nums[i])
            self.dfs(nums, i, target - nums[i], curSum, res)
            del curSum[-1]