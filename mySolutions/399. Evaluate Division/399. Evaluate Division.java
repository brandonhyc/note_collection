class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // if ()
        
        // 1. build graph
        Map<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        Map<String, ArrayList<Double>> pairValues = new HashMap<>(); 
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String dividend = equation.get(0);
            String divisor = equation.get(1);
            
            // for dividend
            if (!pairs.containsKey(dividend)) {
                pairs.put(dividend, new ArrayList<>());
                pairValues.put(dividend, new ArrayList<>());
            }
            pairs.get(dividend).add(divisor);
            pairValues.get(dividend).add(values[i]);
            
            if (!pairs.containsKey(divisor)) {
                pairs.put(divisor, new ArrayList<>());
                pairValues.put(divisor, new ArrayList<>());
            }
            pairs.get(divisor).add(dividend);
            pairValues.get(divisor).add(1 / values[i]);

        }
        
        // System.out.printf("pairs: %s, \n pairValues: %s\n", Arrays.toString(pairs.entrySet().toArray()), Arrays.toString(pairValues.entrySet().toArray()));
        
        // 2. search result
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            
            String dividend = query.get(0);
            String divisor = query.get(1);
            
            results[i] = pairs.containsKey(dividend) && pairs.containsKey(divisor) ? dfs(pairs, pairValues, new HashSet(), dividend, divisor, 1.0) : -1.0;
            
        }
        
        return results;
    }
    
    private double dfs(Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> pairValues, Set<String> visited, String dividend, String divisor, double value) {
        // System.out.printf("visited: %s, dividend: %s, divisor: %s, value: %f\n", visited.toString(), dividend, divisor, value);
        if (dividend.equals(divisor)) {
            return value;
        }
        if (visited.contains(dividend)) {
            return -1.0;
        }
        
        ArrayList<String> divisors = pairs.get(dividend);
        ArrayList<Double> quotients = pairValues.get(dividend);
        visited.add(dividend);
        
        double tmp = -1.0;
        for (int i = 0; i < divisors.size(); i++) {
            tmp = dfs(pairs, pairValues, visited, divisors.get(i), divisor, value * quotients.get(i));
            // System.out.printf("then, tmp: %s\n", tmp);
            if (tmp != -1.0) {
                break;
            }
        }
        
        visited.remove(dividend);
        
        return tmp;
    }
}