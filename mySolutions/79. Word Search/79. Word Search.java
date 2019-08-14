class Solution {
    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) {
            return true;
        }

        boolean result = false;
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (board[x][y] == word.charAt(0)) {
                    result = dfs(board, word, 0, x, y);
                }
            }
        }
        return result;
    }

    private boolean dfs(char[][] board, String word, int start, int ox, int oy) {

        boolean result = false;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < dx.length; i++) {
            int nx = ox + dx[i];
            int ny = oy + dy[i];

            if (!(0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length)) {
                return false;
            }

            if (board[nx][ny] == word.charAt(start)) {

                if (word.charAt(word.length() - 1) == board[nx][ny]) {
                    return true;
                }

                result = result || dfs(board, word, start + 1, nx, ny);
            }
        }

        return result;

    }
}