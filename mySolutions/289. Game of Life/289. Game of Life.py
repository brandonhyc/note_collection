class Solution:
    DIRS = [[1, 1], [-1, -1], [1, 0], [0, 1], [-1, 0], [0, -1], [1, -1], [-1, 1]]
    DIED_TO_LIVE = 2
    LIVE_TO_DIE = -1
    
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0:
            return
        self.nextGen(board)
        return 
        
    def nextGen(self, board):
        
        for y in range(len(board)):
            for x in range(len(board[0])):
                board[y][x] = self.nextDay(board, x, y) 
        
        for y in range(len(board)):
            for x in range(len(board[0])):
                board[y][x] = 1 if board[y][x] == self.DIED_TO_LIVE else board[y][x]
                board[y][x] = 0 if board[y][x] == self.LIVE_TO_DIE else board[y][x]
        
        return
    
    
    def nextDay(self, board, x, y):
        liveCount = 0
        for i in range(len(self.DIRS)):
            nx = self.DIRS[i][0] + x
            ny = self.DIRS[i][1] + y
            
            if (nx < 0 or nx >= len(board[0]) or ny < 0 or ny >= len(board)):
                continue
            if (board[ny][nx] == 1 or board[ny][nx] == self.LIVE_TO_DIE):
                liveCount += 1
        if board[y][x] == 1:
            if liveCount == 2 or liveCount == 3:
                return 1
            else:
                return self.LIVE_TO_DIE
        elif board[y][x] == 0:
            if liveCount == 3:
                return self.DIED_TO_LIVE
            else:
                return 0
