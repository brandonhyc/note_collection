class Solution:
    DIRS = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    
    def generateMatrix(self, n: int) -> List[List[int]]:
        if n == 0:
            return []
        matrix = [[-1 for i in range(n)] for j in range(n)]

        cy = 0
        cx = 0
        d = 0
        count = 1
        
        for i in range(n * n):
            matrix[cy][cx] = count
            count += 1
            ny = cy + self.DIRS[d][0]
            nx = cx + self.DIRS[d][1]
            
            if self.isBorder(matrix, nx, ny):
                d = (d + 1) % 4
                ny = cy + self.DIRS[d][0]
                nx = cx + self.DIRS[d][1]

            cy = ny
            cx = nx
        return matrix
    
    def isBorder(self, matrix, x, y):
        return x < 0 or x > len(matrix[0]) - 1 or y < 0 or y > len(matrix) - 1 or matrix[y][x] != -1