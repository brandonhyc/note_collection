class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        if len(num1) == 0 and len(num2) == 0:
          return "0"
        
        p1 = len(num1) - 1
        p2 = len(num2) - 1
        
        carry = 0
        total = ""
        
        while p1 >= 0 or p2 >= 0:
          n1 = ord(num1[p1]) - ord('0') if p1 >= 0 else 0
          n2 = ord(num2[p2]) - ord('0') if p2 >= 0 else 0
          
          sum = n1 + n2 + carry
          if sum > 9:
            carry = 1
            sum = sum % 10
          else:
            carry = 0
          
          total = str(sum) + total
          
          p1 -= 1
          p2 -= 1
        
        if carry == 1:
          total = str(carry) + total
        
        return total
        