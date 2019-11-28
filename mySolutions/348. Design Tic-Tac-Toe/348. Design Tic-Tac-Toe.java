class TicTacToe {

    /** Initialize your data structure here. */
    int[][] game = new int[0][0];
    
    public TicTacToe(int n) {
        game = new int[n][n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // assume all moves are valid
        int x0 = col;
        int y0 = row;
        
        game[y0][x0] = player;

        boolean isVerticalValid = true;
        boolean isHorizontalValid = true;
        boolean isDiagnoalValid = true;
        boolean isCoDiagnoalValid = true;
        
        // vertical
        for (int y = 0; y < game.length; y++) {
            if (game[y][x0] != player) {
                isVerticalValid = false;
            }
        }
        
        // horizontal
        for (int x = 0; x < game[0].length; x++) {
            if (game[y0][x] != player) {
                isHorizontalValid = false;
            }
        }
        
        // diagonal
        for (int x = 0; x < game[0].length; x++) {
            int b = y0 - x0;
            int y = x + b;
            
            if (y < 0 || y > game.length - 1 || game[y][x] != player) {
                isDiagnoalValid = false;
            }
        }
        
        // co-diagonal
        for (int y = 0; y < game.length; y++) {
            int b = y0 + x0;
            int x = -y + b;
            
            if (x < 0 || x > game[0].length - 1 || game[y][x] != player) {
                isCoDiagnoalValid = false;
            }
        }
        
        return (isVerticalValid || isHorizontalValid || isDiagnoalValid || isCoDiagnoalValid) ? player : 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */