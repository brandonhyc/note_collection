class Solution:
    def combinationSum2(self, nums: List[int], target: int) -> List[List[int]]:
        if len(nums) == 0:
            return []
        
        start = 0
        curSum = []
        res = []
        
        nums.sort()
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
            if i - 1 >= 0 and nums[i] == nums[i - 1] and start != i:
                continue
            curSum.append(nums[i])
            self.dfs(nums, i + 1, target - nums[i], curSum, res)
            del curSum[-1]