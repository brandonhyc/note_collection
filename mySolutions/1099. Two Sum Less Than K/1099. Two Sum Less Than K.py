import sys

class Solution:
    def twoSumLessThanK(self, arr: List[int], k: int) -> int:
        if len(arr) == 0:
            return -1
        
        arr.sort()
        
        closestSmaller = sys.maxsize
        
        left = 0
        right = len(arr) - 1
        
        while left < right:
            sumOfTwo = arr[left] + arr[right]
            
            if sumOfTwo >= k:
                right -= 1
                
            else:
                if closestSmaller == sys.maxsize or k - closestSmaller > k - sumOfTwo:
                    closestSmaller = sumOfTwo
                    
                left += 1
        if closestSmaller == sys.maxsize:
            return -1
        
        return closestSmaller