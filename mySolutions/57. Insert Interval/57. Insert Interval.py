class Solution(object):
    def insert(self, intervals, newInterval):
        """
        :type intervals: List[List[int]]
        :type newInterval: List[int]
        :rtype: List[List[int]]
        """
        
        merged = []
        start = 0
        end = 1
        
        newStart = newInterval[start]
        newEnd = newInterval[end]

        intervals.sort(key = lambda x: x[start])
        
        old = 0
        while old < len(intervals) and intervals[old][end] < newInterval[start]:
            merged.append(intervals[old])
            old += 1

        while old < len(intervals) and newInterval[end] >= intervals[old][start]:
            newStart = min(newStart, intervals[old][start])
            newEnd = max(newEnd, intervals[old][end])
            old += 1
        
        merged.append([newStart, newEnd])

        while old < len(intervals):
            merged.append(intervals[old])
            old += 1
        
        return merged