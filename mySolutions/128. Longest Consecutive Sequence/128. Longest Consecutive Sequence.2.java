class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            
            int distanceToLeft = map.containsKey(num - 1) ? map.get(num - 1) : 0;
            int distanceToRight = map.containsKey(num + 1) ? map.get(num + 1) : 0;
            
            int sum = 1 + distanceToLeft + distanceToRight;
            
            map.put(num, sum);
            if (map.containsKey(num - distanceToLeft)) {
                map.put(num - distanceToLeft, sum);
            }
            if (map.containsKey(num + distanceToRight)) {
                map.put(num + distanceToRight, sum);
            }
            // System.out.printf("num: %d, left: %d, right: %d, sum: %d, map: %s\n", num, distanceToLeft, distanceToRight, sum, Arrays.toString(map.entrySet().toArray()));
        }
        
        int max = 0;
        for (Integer key: map.keySet()) {
            max = Math.max(map.get(key), max);
        }
        
        
        return max;
    }
}