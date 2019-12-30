class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False
        
        normal = x
        reverse = 0
        
        if normal != 0 and normal % 10 == 0:
            return False
        
        while normal > reverse:
            reverse = 10 * reverse + normal % 10
            normal = normal // 10
            # print("reverse", reverse, "normal", normal)
        
        # 123321 or 12321
        return normal == reverse or normal == reverse // 10