class Solution {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (y > 0 && y < board.length - 1 && x > 0 && x < board[0].length - 1) {
                    continue;
                }
                if (board[y][x] == 'O') {
                    // System.out.printf("x: %s, y: %s\n", x, y);
                    board[y][x] = 'V';
                    dfs(board, x, y);
                }
            }
        }
        
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] == 'V') {
                    board[y][x] = 'O';
                } else if (board[y][x] =='O') {
                    board[y][x] = 'X';
                }
            }
        }
        
        return;
    }
    
    private void dfs(char[][] board, int x, int y) {
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx < 0 || nx >= board[0].length || ny < 0 || ny >= board.length) {
                continue;
            }
            if (board[ny][nx] == 'V') {
                continue;
            }
            if (board[ny][nx] == 'X') {
                continue;
            }
            
            board[ny][nx] = 'V';
            
            dfs(board, nx, ny);
        }
    }  
}