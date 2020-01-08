class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        chars = {}
        res = []
        for i in range(len(S)):
            chars[S[i]] = i
        
        end = 0
        start = 0
        
        for pos in range(len(S)):
            
            end = max(chars[S[pos]], end)
            if end == pos:
                res.append(end - start + 1)
                start = pos + 1
        
        return res