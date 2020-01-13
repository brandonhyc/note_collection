class Solution:
    def restoreIpAddresses(self, s: str) -> List[str]:
        start = 0
        path = ""
        res = []
        k = 4
        self.dfs(s, start, path, k, res)
        
        return res
    
    def dfs(self, s, start, path, k, res):
        # print(len(s), start, path)
        if start == len(s) and k == 0:
            res.append(path[1:])
            return 
        
        if start >= len(s) or k == 0:
            return
        
        for end in range(start, start + 3):
            numStr = s[start : end + 1]
            if self.isValid(numStr):
                path = path + "." + numStr
                self.dfs(s, end + 1, path, k - 1, res)
                path = path[: -1 - len(numStr)]
            
        
    def isValid(self, numStr):
        if numStr[0] == "0" and len(numStr) > 1:
            return False
        num = int(numStr)
        return num >= 0 and num <= 255