class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        if n == 0 or k == 0:
            return []
        start = 1
        comb = []
        res = []
        
        self.dfs(n, k, start, comb, res)
        
        return res
    
    def dfs(self, n, k, start, comb, res):
        if k == 0:
            res.append(comb[:])
            return
        
        for i in range(start, n + 1):
            comb.append(i)
            self.dfs(n, k - 1, i + 1, comb, res)
            del comb[-1]
            
        
