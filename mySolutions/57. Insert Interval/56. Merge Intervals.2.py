class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        
        if len(intervals) < 2:
            return intervals
        
        START = 0
        END = 1
        res = []
        intervals.sort(key = lambda x : x[START])
        
        prev = intervals[0]
        
        for inv in intervals:
            if prev[END] < inv[START]:
                res.append(prev)
                prev = inv
            elif prev[END] >= inv[START]:
                prev[END] = max(prev[END], inv[END])
        
        res.append(prev)
        
        return res