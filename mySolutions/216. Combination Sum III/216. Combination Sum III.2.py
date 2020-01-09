class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        if n == 0:
            return []
        
        start = 1
        end = 9
        curSum = []
        res = []
        
        self.dfs(k, start, end, n, curSum, res)
        return res    
        
    def dfs(self, k, start, end, target, curSum, res):
        if target < 0 or k < 0:
            return 
        
        if target == 0 and k == 0:
            res.append(curSum[:])
            return
        
        for i in range(start, end + 1):
            curSum.append(i)
            self.dfs(k - 1, i + 1, end, target - i, curSum, res)
            del curSum[-1]