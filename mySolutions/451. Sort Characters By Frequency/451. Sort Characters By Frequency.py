import heapq

class Solution:
    def frequencySort(self, s: str) -> str:
        counts = {}
        chars = []
        
        for ch in s:
            if ch not in counts:
                counts[ch] = 0
                chars.append(ch)
            counts[ch] += 1
            
        chars.sort(key = lambda ch: counts.get(ch))
        
        res = ""
        for ch in chars:
            res = ch * counts.get(ch) + res
            
        return res