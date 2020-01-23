class Solution:
    
    DIRS = [[0, 1], [0, -1], [1, 0], [-1, 0]]
    def updateMatrix(self, matrix: List[List[int]]) -> List[List[int]]:
        if len(matrix) == 0:
            return []
        
        queue = collections.deque()
        for y in range(len(matrix)):
            for x in range(len(matrix[0])):
                if matrix[y][x] == 1:
                    matrix[y][x] = sys.maxsize
                if matrix[y][x] == 0:
                    queue.append([y, x])
                    
        while len(queue) != 0:
            pos = queue.popleft()
            curDist = matrix[pos[0]][pos[1]]
            
            for i in range(len(self.DIRS)):
                ny = self.DIRS[i][0] + pos[0]
                nx = self.DIRS[i][1] + pos[1]
                
                if nx < 0 or nx >= len(matrix[0]) or ny < 0 or ny >= len(matrix):
                    continue
                if matrix[ny][nx] > curDist + 1:
                    matrix[ny][nx] = curDist + 1
                    queue.append([ny, nx])
                    
        return matrix
            
        