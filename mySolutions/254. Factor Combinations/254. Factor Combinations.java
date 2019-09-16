class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> results = new ArrayList<>();
        
        backtrack(results, n, 2, new ArrayList<>());
        return results;
    }
    
    private void backtrack(List<List<Integer>> results, int dividend, int start, List<Integer> divisorList) {
        // System.out.printf(" start(divisor): %d, List: %s, dividend: %d\n", start, divisorList.toString(), dividend);
        
        if (dividend == 1) {
            if (divisorList.size() > 1) {
                results.add(new ArrayList<>(divisorList));
            }
            return;
        }
        
        for (int divisor = start; divisor <= dividend; divisor++) {
            
            if (dividend % divisor != 0) {
                continue;
            }
            
            divisorList.add(divisor);
            backtrack(results, dividend / divisor, divisor, divisorList);
            divisorList.remove(divisorList.size() - 1);
            
        }
        return;
    }
}