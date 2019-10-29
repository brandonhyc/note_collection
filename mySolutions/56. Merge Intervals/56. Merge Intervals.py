class Solution(object):
    def merge(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: List[List[int]]
        """
        if len(intervals) < 2:
            return intervals

        merged = []        
        start = 0
        end = 1

        intervals.sort(key = lambda x: x[start])

        prevInterval = intervals[0]
        
        for i in range(1, len(intervals)):
            nextInterval = intervals[i]
            
            if prevInterval[end] >= nextInterval[start]:
                prevInterval[start] = min(prevInterval[start], nextInterval[start])
                prevInterval[end] = max(prevInterval[end], nextInterval[end])
            else:
                merged.append(prevInterval)
                prevInterval = nextInterval
        
        merged.append(prevInterval)

        return merged
