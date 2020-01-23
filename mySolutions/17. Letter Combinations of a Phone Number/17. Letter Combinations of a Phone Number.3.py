class Solution:
    numStrMap = [" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    def letterCombinations(self, digits: str) -> List[str]:
        if len(digits) == 0:
            return []
        res = []
        path = ""
        self.dfs(digits, 0, res, path)
        return res
        
    def dfs(self, digits, start, res, path):
        if start == len(digits):
            res.append(path[:])
            return
        
        for ch in self.numStrMap[int(digits[start])]:
            path = path + ch
            self.dfs(digits, start + 1, res, path)
            path = path[: -1]
        