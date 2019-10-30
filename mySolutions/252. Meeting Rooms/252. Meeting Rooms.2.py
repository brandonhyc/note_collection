class Solution(object):
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: bool
        """
        start = 0
        end = 1
        intervals.sort(key = lambda x: x[start])

        for i in range(1, len(intervals)):
            if intervals[i - 1][end] > intervals[i][start]:
                return False

        return True