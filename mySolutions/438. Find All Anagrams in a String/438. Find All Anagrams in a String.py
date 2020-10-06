class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        m = defaultdict(int)
        for ch in p:
            m[ch] += 1
        res = []
        uniques = len(m.keys())
        l = 0
        
        for r in range(0, len(s)):
            ch = s[r]
            if m[ch] == 0:
                while l < r and s[l] != ch:
                    m[s[l]] += 1
                    if m[s[l]] == 1:
                        uniques += 1
                    l += 1
                l += 1
            elif m[ch] != 0:
                m[ch] -= 1
                if m[ch] == 0:
                    uniques -= 1
            
            if uniques == 0:
                res.append(l)
                
        return res