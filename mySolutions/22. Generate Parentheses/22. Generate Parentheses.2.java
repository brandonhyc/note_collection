class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        
        List<String> results = new ArrayList<>();
        backtrack(results, n, n, new StringBuilder());
        
        return results;
    }
    
    private void backtrack(List<String> results, int leftCount, int rightCount, StringBuilder sb) {
        if (leftCount == 0 && rightCount == 0) {
            results.add(sb.toString());
            return;
        }
        
        // add left
        if (leftCount > 0) {
            sb.append("(");
            backtrack(results, leftCount - 1, rightCount, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        
        
        // add right
        if (rightCount > leftCount) {
            sb.append(")");
            backtrack(results, leftCount, rightCount - 1, sb);
            sb.delete(sb.length() - 1, sb.length());
        }
        
    }
}