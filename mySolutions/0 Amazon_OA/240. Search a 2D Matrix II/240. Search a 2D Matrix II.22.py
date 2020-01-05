class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0:
            return False
        y = 0
        x = len(matrix[0]) - 1
        
        while y <= len(matrix) - 1 and x >= 0:
            if matrix[y][x] == target:
                return True
            elif target < matrix[y][x]:
                x -= 1
            elif target > matrix[y][x]:
                y += 1
        
        return False
        