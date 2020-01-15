class Solution:
    DIRS = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    def floodFill(self, image: List[List[int]], sr: int, sc: int, newColor: int) -> List[List[int]]:
        oldColor = image[sr][sc]
        if oldColor == newColor:
            return image
        self.dfs(image, sr, sc, oldColor, newColor)
        
        return image
    
    def dfs(self, image, y, x, c1, c2):
        # exit
        if not self.colorMatch(image, x, y, c1):
            return 
        
        image[y][x] = c2
        
        for i in range(len(self.DIRS)):
            ny = y + self.DIRS[i][0]
            nx = x + self.DIRS[i][1]
            self.dfs(image, ny, nx, c1, c2)
    
    def colorMatch(self, image, x, y, c1):
        return y >= 0 and y <= len(image) - 1 and x >= 0 and x <= len(image[0]) - 1 and image[y][x] == c1 
        