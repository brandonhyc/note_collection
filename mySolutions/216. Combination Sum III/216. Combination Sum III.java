class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> results = new ArrayList<>();
        backtrack(k, n, results, new ArrayList<>(), 0, 1);

        return results;
    }

    private void backtrack(int k, int n, List<List<Integer>> results, List<Integer> adders, int sum, int start) {
        if (sum == n && k == 0) {
            results.add(new ArrayList<>(adders));
        }
        if (sum > n || k == 0 || (start < 1 || start > 9)) {
            return;
        }

        backtrack(k, n, results, adders, sum, start + 1);

        adders.add(start);
        backtrack(k - 1, n, results, adders, sum + start, start + 1);
        adders.remove(adders.size() - 1);

        return;
    }
}