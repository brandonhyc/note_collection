class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        List<List<String>> results = new ArrayList<>();
        solve(n, results, board, 0);

        return results;
    }
    
    private void solve(int n, List<List<String>> results, char[][] board, int startX) {
        if (startX == n) {
            
            results.add(convertArrayToList(board));
            
            return;
        }
        
        for (int y = 0; y < n; y++) {
            board[startX][y] = 'Q';
            if (isVerticallyValid(n, board, y)
               && isHorizontallyValid(n, board, startX)
               && isDiagonallyValid(n, board, startX, y)) {
                
                solve(n, results, board, startX + 1);
            }
            board[startX][y] = '.';
        }
        
    }

    private boolean isVerticallyValid(int n, char[][] board, int y) {
        boolean hasQueue = false;
        for (int x = 0; x < n; x++) {
            if (hasQueue && board[x][y] == 'Q') {
                return false;
            }
            if (board[x][y] =='Q') {
                hasQueue = true;
            }
        }
        return true;
    }
    
    private boolean isHorizontallyValid(int n, char[][] board, int x) {
        boolean hasQueue = false;
        for (int y = 0; y < n; y++) {
            if (hasQueue && board[x][y] == 'Q') {
                return false;
            }
            if (board[x][y] =='Q') {
                hasQueue = true;
            }
        }
        return true;
    }
    
    private boolean isDiagonallyValid(int n, char[][] board, int ox, int oy) {
        // check / 
        boolean hasQueue = false;
        for (int y = oy, x = ox; y < n && x >= 0; y++, x--) {
            if (hasQueue && board[x][y] == 'Q') {
                return false;
            }
            if (board[x][y] =='Q') {
                hasQueue = true;
            }
        }
        
        for (int y = oy - 1, x = ox + 1; y >= 0 && x < n; y--, x++) {
            if (hasQueue && board[x][y] == 'Q') {
                return false;
            }
            if (board[x][y] =='Q') {
                hasQueue = true;
            }
        }
        
        // check \
        hasQueue = false;
        for (int y = oy - 1, x = ox - 1; y >= 0 && x >= 0; y--, x--) {
            if (hasQueue && board[x][y] == 'Q') {
                return false;
            }
            if (board[x][y] =='Q') {
                hasQueue = true;
            }
        }
        
        for (int y = oy, x = ox; y < n && x < n; y++, x++) {
            if (hasQueue && board[x][y] == 'Q') {
                return false;
            }
            if (board[x][y] =='Q') {
                hasQueue = true;
            }
        }
        return true;
    }
    
    private List<String> convertArrayToList(char[][] board) {
        List<String> result = new ArrayList<>(); 
        for (char[] row: board) {
            result.add(new String(row));
        }
        
        return result;
    }
}