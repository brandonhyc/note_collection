class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) return false;
                if (board[j][i] != '.' && !col.add(board[j][i])) return false;
                int y = j / 3 + 3 * (i / 3);
                int x = j % 3 + 3 * (i % 3);
                if (board[y][x] != '.' && !box.add(board[y][x])) return false;
                
            }
        }
        
        return true;        
    }
}