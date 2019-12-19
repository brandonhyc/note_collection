class Solution:

    LAND = '1'
    WATER = '0'
    VISITED = '-1'
    DIRS = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    def numIslands(self, grid: List[List[str]]) -> int:

        if len(grid) == 0:
            return 0

        count = 0

        for y in range(len(grid)):
            for x in range(len(grid[0])):
                if grid[y][x] == self.LAND:
                    count += 1
                    grid[y][x] = self.VISITED
                    self.dfs(grid, x, y)

        return count

    def dfs(self, grid, x, y):
        for i in range(len(self.DIRS)):
            nx = x + self.DIRS[i][0]
            ny = y + self.DIRS[i][1]

            if self.isLand(grid, nx, ny):
                grid[ny][nx] = self.VISITED
                self.dfs(grid, nx, ny)


    def isLand(self, grid, x, y):
        return x >= 0 and x < len(grid[0]) and y >= 0 and y < len(grid) and grid[y][x] == self.LAND