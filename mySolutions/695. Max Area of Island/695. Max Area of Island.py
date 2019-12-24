class Solution:
    DIRS = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    ISLAND = 1
    WATER = 0
    VISITED = 2
    
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if len(grid) == 0:
            return 0
        
        maxArea = 0
        for y in range(len(grid)):
            for x in range(len(grid[0])):
                if grid[y][x] == self.ISLAND:
                    
                    grid[y][x] = self.VISITED
                    area = self.dfs(grid, x, y)
                    # print("x", x, "y", y, "area", area)
                    maxArea = max(area, maxArea)
                    
        return maxArea
    
    def dfs(self, grid, x, y):
        totalArea = 1
        
        for i in range(len(self.DIRS)):
            nx = self.DIRS[i][1] + x
            ny = self.DIRS[i][0] + y
            
            if self.isIsland(grid, nx, ny):
                grid[ny][nx] = self.VISITED
                area = self.dfs(grid, nx, ny)
                totalArea += area
                # print("nx", nx, "ny", ny, "totalArea", totalArea)
                
        return totalArea
    
    def isIsland(self, grid, x, y):
        return x >= 0 and x < len(grid[0]) and y >= 0 and y < len(grid) and grid[y][x] == self.ISLAND
        