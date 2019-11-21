class Solution:
    def totalNQueens(self, n: int):
        
        matrix = [['.' for i in range(n)] for j in range(n)]
        return self.dfs(matrix, 0);

    def dfs(self, matrix, y0):
        count = 0
        if y0 > len(matrix) - 1:
          return 1        
        for x0 in range(len(matrix)):
            matrix[y0][x0] = 'Q'
            if self.isValid(matrix, x0, y0):
                count += self.dfs(matrix, y0 + 1)
            matrix[y0][x0] = '.'

        return count    

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