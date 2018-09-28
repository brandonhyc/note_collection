// 思路: 难. 很难. 想到脑袋都开花了才弄出来. 
//  搞清楚扫描方式
// 图片



public class Solution {
    /*
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        // write your code here
        List<List<String>> results = new ArrayList<>();

        if (n <= 0) {
            return results;
        }

        search(n, results, new ArrayList<>());
        return results;
    }

    private void search(int n, 
                        List<List<String>> results, 
                        List<Integer> cols) {

        if (cols.size() == n) {
            results.add(drawChessboard(cols));
            return;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            // row: [0,1,2,3]
            //  col: 4 2 1 3
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
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

    private boolean isValid(List<Integer> cols, int nextX) {
        // iterate again to check columIndex match in each row 
        int nextY = cols.size();
        for (int lastY = 0; lastY < nextY; lastY++) {
            int lastX = cols.get(lastY);
            
            if (nextX == lastX) {
                return false;
            }
            if (nextX + nextY == lastX + lastY){
                return false;
            }
            if (nextX - nextY == lastX - lastY) {
                return false;
            }
        }
        return true;
    }
    
}