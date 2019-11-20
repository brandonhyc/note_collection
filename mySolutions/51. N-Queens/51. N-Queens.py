class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:



    def isValid(self, matrix):
        return self.isValidH(matrix) and self.isValidV(matrix) and self.isValidDia(matrix)


    def isValidDia(self, matrix):
        
        