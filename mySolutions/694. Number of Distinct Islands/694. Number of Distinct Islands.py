class Solution:
    def numDistinctIslands(self, grid: List[List[int]]) -> int:
      visited = [[False for i in range(len(grid[0]))] for j in range(len(grid))]
      count = 0
      set = []
      for x in range(len(grid)):
        for y in range(len(grid[0])):
          if not visited[x][y] and grid[x][y] == 1:
            shape = self.dfs(grid, x, y, visited, 'o')
            if shape not in set:
              count += 1
              set.append(shape)

      return count
    
    def dfs(self, grid, x, y, visited, last):
      
      if x < 0 or x > len(grid) - 1 or y < 0 or y > len(grid[0]) - 1 or grid[x][y] == 0:
        return ""
      if visited[x][y]:
        return ""
      visited[x][y] = True
      # print ("x", x, "y", y, last)
    
      dy = [1, 0, -1, 0]
      dx = [0, 1, 0, -1]
      d = ['r', 'd', 'l', 'u']
      
      nextStep = last + "" 
      for i in range(4):
        nextStep = nextStep + self.dfs(grid, x + dx[i], y + dy[i], visited, d[i])
        
      return nextStep + "b"