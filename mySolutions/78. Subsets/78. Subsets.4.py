class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 0:
            return []
        
        start = 0
        res = []
        subset = []
        self.dfs(nums, start, subset, res)
        
        return res
    
    def dfs(self, nums, start, subset, res):
        
        # exit
        res.append(subset[:])
        
        for i in range(start, len(nums)):
            subset.append(nums[i])
            self.dfs(nums, i + 1, subset, res)
            del subset[-1]
            
        