class TicTacToe:

    rows = [];
    cols = [];
    
    diagonal = 0;
    antidiagonal = 0;
    
    def __init__(self, n: int):
        """
        Initialize your data structure here.
        """
        self.rows = [0 for x in range(n)]
        self.cols = [0 for y in range(n)]
        

    def move(self, row: int, col: int, player: int) -> int:
        """
        Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins.
        """
        
        size = len(self.rows)
        self.rows[row] += 1 if player == 1 else -1
        self.cols[col] += 1 if player == 1 else -1
        
        if row == col:
            self.diagonal += 1 if player == 1 else -1
        
        if row + col == size - 1:
            self.antidiagonal += 1 if player == 1 else -1
        
        if self.rows[row] == size \
            or self.cols[col] == size \
            or self.diagonal == size \
            or self.antidiagonal == size:
            return 1 
        
        if self.rows[row] == -size \
            or self.cols[col] == -size \
            or self.diagonal == -size \
            or self.antidiagonal == -size :
            return 2

        return 0;
# Your TicTacToe object will be instantiated and called as such:
# obj = TicTacToe(n)
# param_1 = obj.move(row,col,player)