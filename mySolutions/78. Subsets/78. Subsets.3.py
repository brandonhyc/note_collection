class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        results = []
        self.dfs(nums, 0, [], results)
        return results
        
    def dfs(self, nums, start, subset, results):
        if (start == len(nums)):
            results.append(subset[:])
            return
        self.dfs(nums, start + 1, subset, results)
        subset.append(nums[start])
        self.dfs(nums, start + 1, subset, results)
        del subset[len(subset) - 1]

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        results = []
        self.dfs(nums, 0, [], results)
        return results
        
    def dfs(self, nums, start, subset, results):
        # add into result for each step
        results.append(subset[:])

        if start == len(nums):
            return 

        subset.append(nums[start])
        for i in range(start + 1, len(nums)):
            self.dfs(nums, i, subset, results)
