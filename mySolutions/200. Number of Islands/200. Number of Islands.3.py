class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        
        visited = [[False for j in range(len(grid[0]))] for i in range(len(grid))]
        count = 0
        for x in range(len(grid)):
          for y in range(len(grid[0])):
            if grid[x][y] == "1" and not visited[x][y]:
              self.bfs(grid, x, y, visited)
              count += 1
              
        return count
    
    def bfs(self, grid, x, y, visited):
      if x < 0 or x > len(grid) - 1 or \
        y < 0 or y > len(grid[0]) -1 or \
        grid[x][y] == "0":
        return
      
      if visited[x][y]:
        return
      
      visited[x][y] = True
      
      dx = [1, 0, -1, 0]
      dy = [0, 1, 0, -1]
      
      for i in range(4):
        self.bfs(grid, x + dx[i], y + dy[i], visited)
      
      return