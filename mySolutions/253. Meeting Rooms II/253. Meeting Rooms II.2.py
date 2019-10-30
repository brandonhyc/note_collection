import heapq    
class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        if len(intervals) < 2:
            return len(intervals)

        start = 0
        end = 1

        maxRoom = 0
        minHeap = []
        
        intervals.sort(key = lambda x: x[start])
        
        heapq.heappush(minHeap, intervals[0][end])

        for i in range(1, len(intervals)):
            nextMeeting = intervals[i]
            
            while minHeap and minHeap[0] < nextMeeting[start]:
                heapq.heappop(minHeap)

            heapq.heappush(minHeap, nextMeeting[end])
            maxRoom = max(len(minHeap), maxRoom)

        return maxRoom