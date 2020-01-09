class Solution:
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        path = []
        start = 0
        visited = [False for i in range(len(nums))]
        nums.sort()
        self.dfs(nums, path, visited, start, res)
        return res        
    
    def dfs(self, nums, path, visited, start, res):
        if len(path) == len(nums):
            res.append(path[:])
            return
        
        for i in range(len(nums)):
            if visited[i]:
                continue
            if i - 1 >= 0 and nums[i] == nums[i - 1] and not visited[i - 1]:
                continue
            
            path.append(nums[i])
            visited[i] = True
            self.dfs(nums, path, visited, i, res)
            visited[i] = False
            del path[-1]
            