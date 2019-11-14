class Solution:
    def convert(self, s: str, rowNum: int) -> str:

      rows = []
      goingDown = False
      
      curRow = 0
      
      for ch in s:
        if curRow > len(rows) - 1:
          rows.append([])
        rows[curRow].append(ch)
        
        if curRow == 0 or curRow == rowNum - 1:
          goingDown = not goingDown
          
        curRow = curRow + 1 if goingDown else curRow - 1
        
      res = ""
      for row in rows:
        res += "".join(row)
        
      return res
      