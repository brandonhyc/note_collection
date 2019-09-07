class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> map_num_length = new HashMap<>();
        int maxLength = 0;
        for (int n : nums) {
            
            if (map_num_length.containsKey(n)) {
                continue;
            } 
            else {
                int leftLength = map_num_length.containsKey(n - 1) ? map_num_length.get(n - 1) : 0;
                int rightLength = map_num_length.containsKey(n + 1) ? map_num_length.get(n + 1) : 0;
                
                int sum = 1 + leftLength + rightLength;
                
                // System.out.printf("n: %d, leftLength: %d, rightLength: %d, sum: %d\n", n, leftLength, rightLength, sum);
                
                maxLength = Math.max(sum, maxLength);
                
                map_num_length.put(n, sum);
                map_num_length.put(n - leftLength, sum);
                map_num_length.put(n + rightLength, sum);
                
            }
            
        }
        
        return maxLength;
        
    }
}