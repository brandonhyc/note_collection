class Solution:
    def intToRoman(self, num: int) -> str:
      fives = ["V", "L", "D"]
      tens = ["I", "X", "C", "M"]
      
      res = ""
      i = 0
      s = str(num)
      while i < len(s):

        rom = ""
        n = int(s[len(s) - i - 1])
        
        if n == 9:
          rom = tens[i] + tens[i + 1]
        elif n == 4:
          rom = tens[i] + fives[i]
          
        if n != 4 and n != 9:
          if n >= 5:
            rom = fives[i]
            n -= 5
          
          for j in range(n):
            rom = rom + tens[i]
        # print ("n:", n, "rom", rom)
        i += 1
        res = rom + res
      return res