class Solution:
    def getFactors(self, n: int) -> List[List[int]]:
        
        if n == 0:
            return []
        path = []
        res = []
        start = 2
        
        self.dfs(res, n, start, path)
        
        return res
    
    def dfs(self, res, n, start, path):
        if n == 1 and len(path) > 1:
            res.append(path[:])
            return
        
        for i in range(start, n + 1):
            if n % i == 0:
                path.append(i)
                self.dfs(res, n // i, i, path)
                del path[-1]