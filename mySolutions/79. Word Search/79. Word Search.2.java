class Solution {
    public boolean exist(char[][] board, String word) {
        
        
        // [[A], 
        //  [B], 
        //  [C]]
        boolean doesExist = false;
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.length() > 0 && word.charAt(0) == board[i][j]) {
                    doesExist = doesExist || matchSuffix(board, word, 1, i, j);
                }
            }
        }
        return doesExist;
    }
    
    
    private boolean matchSuffix(char[][] board, String word, int start, int x, int y) {
        if (word.length() == start) {
            return true;
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        boolean doesExist = false;
        
        board[x][y] ^= 256;
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length
               && word.charAt(start) == board[nx][ny]) {
                doesExist = doesExist || matchSuffix(board, word, start + 1, nx, ny);
            }
            
        }
        board[x][y] ^= 256;
        
        return doesExist;
        
    }
}