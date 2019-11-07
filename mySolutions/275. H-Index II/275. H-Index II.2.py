class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0

        left = 0
        right = len(citations) - 1

        while left < right:
            mid = left + (right - left) // 2
            v = citations[mid]
            h = len(citations) - mid

            if v < h:
                left = mid + 1
            else:
                right = mid
        
        if len(citations) - right <= citations[right]:
            return  right
        return len(citations) - right - 1
# i 0 1 2 3
# h 4 3 2 1
# v 0 0 4 4

# h 5 4 3 2 1
# v 0 1 3 5 6

# Find the first value smaller than h-index, h-1
