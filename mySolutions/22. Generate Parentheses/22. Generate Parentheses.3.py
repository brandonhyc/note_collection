class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        if n == 0:
            return []

        results = []
        path = ""
        leftNum = n
        rightNum = n

        self.dfs(leftNum, rightNum, results, path)
        
        return results
        
    def dfs(self, leftNum, rightNum, results, path):
        if leftNum > rightNum or leftNum < 0 or rightNum < 0:
            return 
        if leftNum == 0 and rightNum == 0:
            results.append(path[:])

        path += "("
        self.dfs(leftNum - 1, rightNum, results, path)
        path = path[: -1]
        
        path += ")"
        self.dfs(leftNum, rightNum - 1, results, path)
        path = path[: -1]

