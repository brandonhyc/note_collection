class Solution {
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> results = new ArrayList<>();
        dfs(results, n, 0, 0, "");

        return results;
    }

    private void dfs(List<String> results, int n, int left, int right, String result) {

        if (left == n && right == n) {
            results.add(new String(result));
            return;
        }

        if (left > n || right > n || left < right) {
            return;
        }

        // adding (
        result = result + "(";
        dfs(results, n, left + 1, right, result);
        result = result.substring(0, result.length() - 1);

        // adding )
        result = result + ")";
        dfs(results, n, left, right + 1, result);
        result = result.substring(0, result.length() - 1);

        return;
    }
}