// 第一步是取每一个单词的前序组成一个map<String, Boolean>. map中对应的单词, 为true, 其余为false
// 进行dfs. 每次dfs进行对一次临近4个元素的bfs.
//  剪枝: 若超出范围, 退出. 若不存在前序, 退出. 
// 难点: 太难. 没法说
// 易错点: 出口选错. 可能存在一种情况是单词1是单词2的前序, 因此不可以提早结束dfs.


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

        Set<String> result = new HashSet<String>();
        if (board == null || board.length == 0) {
            return new ArrayList<>(result);
        }

        Map<String, Boolean> prefixIsWord = getPrefixSet(words);
        boolean[][] visited = new boolean[board.length][board[0].length]; 
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(board, result, prefixIsWord, "" + board[i][j], i, j, visited);
                visited[i][j] = false;
            }
        }
        return new ArrayList<String>(result);
    }

    private Map<String, Boolean> getPrefixSet(List<String> words) {
        
        Map<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            String prefix = "";
            for (char c : word.toCharArray()) {
                prefix += c;
                if (!map.containsKey(prefix)) {
                    map.put(prefix, false);
                }
            }
            map.put(word, true);
        }
        return map;
    }

    private void dfs (char[][] board, Set<String> result,
                        Map<String, Boolean> prefixIsWord, 
                        String word, 
                        int x, int y, boolean[][] visited) {
        if (!prefixIsWord.containsKey(word)) {
            return;
        }

        if (prefixIsWord.get(word)) {
            result.add(word);
        }

        for (int i = 0; i < 4; i++) {
            int adjX = x + dx[i];
            int adjY = y + dy[i];

            if (!inside(board, adjX, adjY) || visited[adjX][adjY]) {
                continue;
            }

            visited[adjX][adjY] = true;
            dfs(board, result, prefixIsWord, word + board[adjX][adjY], adjX, adjY, visited);
            visited[adjX][adjY] = false;

        }

        return;
    }

    private boolean inside(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && 
                y >= 0 && y < board[x].length;
    }
}