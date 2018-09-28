public class Solution {
    /**
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        // write your code here

        if (n <= 0) {
            return 0;
        }

        return search(n, 0, new ArrayList<>());
    }

    // cols: col indices in each row
    private int search(int n, int result, List<Integer> cols) {
        
        if (cols.size() == n) {
            return result + 1;
        }

        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!isValid(cols, colIndex)) {
                continue;
            }
            cols.add(colIndex);
            result = search(n, result, cols);
            cols.remove(cols.size() - 1);
        }
        return result;
    }

    private boolean isValid(List<Integer> cols, int nextX) {
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