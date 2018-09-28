public class Solution {
    /*
     * @param n: The number of queens
     * 
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();

        if (n <= 0) {
            return results;
        }

        search(n, results, new ArrayList<>());
    }

    private void search(int n, 
                        List<List<String>> results, 
                        List<Integer> cols) {

        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(codIndex);
            search(n, results, cols);
            cols.remove(cols.size() - 1);
        }
    }

    private List<String> drawChessboard(List<Integer> cols) {
        List<String> chessboard = new ArrayList<>();
        int size = cols.size();
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            String row = "";
            for (int colIndex = 0; colIndex < size; colIndex++) {
                row += (cols.get(rowIndex) == colIndex) ? "Q" : ".";  
            }
            chessboard.add(row);
        }
        return chessboard;
    }

    private booleand isValid(List<Integer> cols, int nextX) {
        int size = cols.size();
        for (int rowIndex = 0; rowIndex < size; rowIndex++) {
            int nextY = cols.get(rowIndex);
            
            if (nextY == nextX) {
                return false;
            }
            if (nextX - nextY ==  
            ) {
                return false;
            }
        }
    }
    
}