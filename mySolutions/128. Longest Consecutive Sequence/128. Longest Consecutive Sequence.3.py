class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        nCMap = {}
        
        for num in nums:
            if num in nCMap:
                continue
            
            left = nCMap.get(num - 1, 0)
            right = nCMap.get(num + 1, 0)
            mid = 1
            
            lenSum = left + right + mid
            # save
            nCMap[num] = lenSum
            
            if left != 0:
                nCMap[num - left] = lenSum
            if right != 0:
                nCMap[num + right] = lenSum
            
        maxLen = 0
        for key in nCMap:
            maxLen = max(nCMap[key], maxLen)
        return maxLen
#             12 13 [] 15
#             2  2  4   1
        
        
        
        