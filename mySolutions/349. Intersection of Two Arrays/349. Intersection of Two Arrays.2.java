class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        
        for (int num : nums1) {
            set.add(num);
        }
        
        for (int num: nums2) {
            if (set.contains(num)) {
                res.add(num);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            // System.out.printf("%s", set.toString());
            result[i] = (int) res.toArray()[i];
        }
        
        return result;
    }
}