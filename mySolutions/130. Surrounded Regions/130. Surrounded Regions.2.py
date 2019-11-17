class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        # mark all uncaptured as V
        for x in range(len(board)):
          for y in range(len(board[0])):
            if (x == 0 or x == len(board) - 1 or y == 0 or y == len(board[0]) - 1) and board[x][y] == 'O':
              self.dfs(board, x, y)
              
        for x in range(len(board)):
          for y in range(len(board[0])):
            if board[x][y] == 'O':
              board[x][y] = 'X'
            if board[x][y] == 'V':
              board[x][y] = 'O'
              
    def dfs(self, board, x, y):
      if x < 0 or x > len(board) - 1 or y < 0 or y > len(board[0]) - 1:
        return
      if board[x][y] != 'O':
        return
      
      board[x][y] = 'V'
      
      dx = [0, 1, 0, -1]
      dy = [1, 0, -1, 0]
      
      for i in range(4):
        self.dfs(board, x + dx[i], y + dy[i])