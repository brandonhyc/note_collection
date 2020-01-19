class Solution:
    def reverse(self, x: int) -> int:
        
        isNegative = False
        if x < 0:
            isNegative = True
            x = -x
            
            
        # 123 % 10 = 3, 123 / 10 = 12
        # 12 % 10 = 2, 12 / 10 = 1
        # 1 % 10 = 1, 1 / 10 = 0
        
        res = 0
        while x != 0:
            res = res * 10 + x % 10
            x = x // 10
            # print("res", res, "x", x)
        
        if res < -pow(2, 31)  or res > pow(2, 31) - 1:
            res = 0
        
        return -res if isNegative else res