class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        
        numSet = set()
        path = []
        res = []
        self.dfs(nums, numSet, path, res)
        return res
    
    def dfs(self, nums, numSet, path, res):
        if len(numSet) == len(nums):
            res.append(path[:])
            return 
        
        for num in nums:
            if num not in numSet:
                path.append(num)
                numSet.add(num)
                self.dfs(nums, numSet, path, res)
                numSet.remove(num)
                del path[-1]