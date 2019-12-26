class Solution:
    DIRS = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    ISLAND = 1
    WATER = 0
    VISITED = 2
    
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        if len(grid) == 0:
            return 0
        
        total = 0
        
        for y in range(len(grid)):
            for x in range(len(grid[0])):
                if grid[y][x] == self.ISLAND:
                    grid[y][x] = self.VISITED
                    total = self.dfs(grid, x, y)
                    return total
                    
        return 0
    
    def dfs(self, grid, x, y):
        total = 0
        
        for i in range(len(self.DIRS)):
            nx = self.DIRS[i][1] + x
            ny = self.DIRS[i][0] + y
            
            if self.isIsWater(grid, nx, ny):
                total += 1
            elif grid[ny][nx] == self.ISLAND:
                grid[ny][nx] = self.VISITED
                perimeter = self.dfs(grid, nx, ny)
                total += perimeter
            # print("nx", nx, "ny", ny, "total", total)
        return total
    
    def isIsWater(self, grid, x, y):
        return x < 0 or x >= len(grid[0]) or y < 0 or y >= len(grid) or grid[y][x] == self.WATER