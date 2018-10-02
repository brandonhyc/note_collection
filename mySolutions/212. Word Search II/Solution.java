public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */

    public static int[] dx = {0, 1, -1, 0};
    public static int[] dy = {1, 0, 0, -1};
    
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here

        List<String> result = new ArrayList<String>();
        if (board == null || board.length == 0) {
            return result;
        }

        int width = board.length;
        int height = board[0].length;
        Map<String, Boolean> prefixIsWord = getPrefixSet(words);
        boolean[][] visited = new boolean[height][width]; 
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                visited[i][j] = true;
                dfs();
                visited[i][j] = false;
            }
        }
    }
    private void dfs (char[][] board, List<String> result,
                        Map<String, Boolean> prefixIsWord, 
                        String word, 
                        int x, int y, boolean[][] visited) {
        if (!prefixIsWord.containsKey(word)) {
            return;
        }

        if (prefixIsWord(word)) {
            result.add(word);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int adjX = x + dx[i];
            int adjY = y + dy[i];

            if (visited[adjX][adjY]) {
                continue;
            }
            if (!inside(board, adjX, adjY)) {
                continue;
            }

            visited[adjX][adjY] = true;
            dfs(board, result, prefixIsWord, word + board[adjX][adjY], adjX, adjY, visited);
            visited[adjX][adjY] = false;

        }

        return;
    }

    private boolean inside(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private Map<String, Boolean> getPrefixSet(List<String> words) {
        return null;
    }
}