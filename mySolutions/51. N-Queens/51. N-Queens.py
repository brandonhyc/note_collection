class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        
        matrix = [['.' for i in range(n)] for j in range(n)]
        res = []
        self.dfs(matrix, res, 0);                

        return res

    def convertToList(self, matrix):
        res = []
        for arr in matrix:
          res.append("".join(arr))
        return res
        
    def dfs(self, matrix, res, y0):
        if y0 > len(matrix) - 1:
            res.append(self.convertToList(matrix))
            return
        
        for  x0 in range(len(matrix)):
            matrix[y0][x0] = 'Q'
            if self.isValid(matrix, x0, y0):
                self.dfs(matrix, res, y0 + 1)
            matrix[y0][x0] = '.'

        return     

    def isValid(self, matrix, x0, y0):
        return self.isValidV(matrix, x0, y0) and self.isValidDia(matrix, x0, y0)
    
    def isValidV(self, matrix, x0, y0):
        for i in range(len(matrix)):
            if i == y0:
                continue
            if matrix[i][x0] == 'Q':
                return False
            
        return True

    def isValidDia(self, matrix, x0, y0):
        k = 1
        b = y0 - x0
        for i in range(len(matrix)):
            y = i + b
            if i == x0 or y == y0 or y < 0 or y > len(matrix) - 1:
                continue
            if matrix[y][i] == 'Q':
                return False
        k = -1
        b = x0 + y0
        for i in range(len(matrix)):
            y = -1 * i + b
            if i == x0 or y == y0 or y < 0 or y > len(matrix) - 1:
                continue
            if matrix[y][i] == 'Q':
                return False    
        
        return True