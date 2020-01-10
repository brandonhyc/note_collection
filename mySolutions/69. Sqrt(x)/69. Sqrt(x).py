class Solution:
    def mySqrt(self, x: int) -> int:
        
        if x == 0:
            return 0
        
        left = 1
        right = x
        
        while left < right:
            mid = (right - left) // 2 + left
            
            if mid * mid <= x and (mid + 1) * (mid + 1) > x:
                return mid
            elif mid * mid < x:
                left = mid + 1
            else:
                right = mid
        
        return right