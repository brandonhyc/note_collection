class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        if (nums.length < 2 || k <= 0 || t < 0) {
            return false;
        }
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
        }
        
        Long bucketSize = Long.valueOf(t) + 1;
        Map<Long, Integer> buckets = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            Long bucketIndex = (Long.valueOf(nums[i]) - min) / bucketSize;
            
            if (buckets.containsKey(bucketIndex - 1) 
                && Long.valueOf(nums[i]) - buckets.get(bucketIndex - 1) <= t) {
                return true;
            }
            if (buckets.containsKey(bucketIndex + 1) 
                && buckets.get(bucketIndex + 1) - Long.valueOf(nums[i]) <= t) {
                return true;
            }
            if (buckets.containsKey(bucketIndex)) {
                // System.out.printf("contains: i: %d, num[i]: %d, bucketIndex: %d", i, nums[i], bucketIndex);
                return true;
            }
            
            buckets.put(bucketIndex, nums[i]);
            
            if (i - k >= 0) {
                // System.out.print();
                buckets.remove(Long.valueOf((nums[i - k] - min) / bucketSize));
            }
        } 
        
        return false;
    }
}