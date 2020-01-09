class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return []
        nums.sort()
        start = 0
        subset = []
        res = []
        self.dfs(nums, start, subset, res)
        
        return res
    
    def dfs(self, nums, start, subset, res):
        
        res.append(subset[:])
        
        for i in range(start, len(nums)):
            if i - 1 >= 0 and nums[i - 1] == nums[i] and i != start:
                continue
            
            subset.append(nums[i])
            self.dfs(nums, i + 1, subset, res)
            del subset[-1]
            
        
        