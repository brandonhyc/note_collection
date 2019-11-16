class Solution(object):
    def convertToTitle(self, n):
        """
        :type n: int
        :rtype: str
        """
        res = "" 
        while n != 0:
          reminder = n % 26
          if reminder == 0:
            // edge case 'Z'. for 'Z', 
            // 0* 26^2 + 1 * 26^1 + 0 * 26^0 = (1-1) * 26^2 26 * 26^0
            
            reminder = 26   
            n -= 26
          n /= 26
          
          ch = chr(reminder - 1 + ord('A'))
          res = ch + res
          
        return res
          
        