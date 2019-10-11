class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> results = new ArrayList<>();
        
        backtrack(n, results, new ArrayList<>());
        return results;
    }
    
    private void backtrack(int dividend, List<List<Integer>> results, List<Integer> divisors) {
        // System.out.printf(" start(divisor): %d, List: %s, dividend: %d\n", start, divisorList.toString(), dividend);
        if (dividend == 0) {
            return;
        }
        
        if (dividend == 1) {
            results.add(new ArrayList<>(divisors));
            return;
        }
        
        for (int divisor = 2; divisor <= dividend; divisor++) {
            if (dividend % divisor != 0) {
                continue;
            }
            
            divisors.add(divisor);
            backtrack(dividend / divisor, results, divisors);
            divisors.remove(divisors.size() - 1);
        }
        
        return;
    }
}