class TicTacToe {

    /** Initialize your data structure here. */
    int[][] table = new int[0][0];
    
    public TicTacToe(int n) {
        table = new int[n][n];
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
        table[row][col] = player;
        int len = table.length;
        boolean rowWin = true, colWin = true, diagWin = true, codiagWin = true;
        
        for (int i = 0; i < len; i ++) {
            if (table[i][col] != player) {
                rowWin = false;
            }
            if (table[row][i] != player) {
                colWin = false;
            }
            if (table[i][i] != player) {
                diagWin = false;
            }
            if (table[len - i - 1][i] != player) {
                codiagWin = false;
            }
        }
        return rowWin || colWin || diagWin || codiagWin ? player : 0;
        
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */