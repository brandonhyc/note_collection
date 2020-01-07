class Solution:
    DIRS = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        if len(matrix) == 0:
            return []
        ans = []
        rows = len(matrix)
        cols = len(matrix[0])
        
        visited = [[False for i in range(cols)] for j in range(rows)]
        cy = 0
        cx = 0
        d = 0
        
        for i in range(rows * cols):
            ans.append(matrix[cy][cx])
            visited[cy][cx] = True
            
            ny = cy + self.DIRS[d][0]
            nx = cx + self.DIRS[d][1]
            
            if self.isBorder(matrix, visited, nx, ny):
                d = (d + 1) % 4
                ny = cy + self.DIRS[d][0]
                nx = cx + self.DIRS[d][1]

            cy = ny
            cx = nx
        return ans
    
    def isBorder(self, matrix, visited, x, y):
        return x < 0 or x > len(matrix[0]) - 1 or y < 0 or y > len(matrix) - 1 or visited[y][x]