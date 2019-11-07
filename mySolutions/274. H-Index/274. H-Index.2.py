# Time: O(nlogn). Space: O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0
        
        citations.sort()
        
        count = 0
        for i in range(len(citations) - 1, -1, -1):
            if citations[i] > count:
                count += 1
            else:
                break
        return count
    
    
# h 4 3 2 1
# v 0 0 4 4

# h 5 4 3 2 1
# v 0 1 3 5 6

# Find the first value smaller than h-index, h-1

# h 1
# v 0

# h 2 1
# v 1 2