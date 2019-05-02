class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    
        Set<Integer> set = new HashSet<>();
        Set<Integer> hashSet = new HashSet<>();
        
        for (int i = 0; i < nums1.length; i++) {
            hashSet.add(nums1[i]);
        }
        
        for (int i = 0; i < nums2.length; i++) {
            if (hashSet.contains(nums2[i])) {
                set.add(nums2[i]);
            }
        }
        
        int[] result = new int[set.size()];
        Object[] array = set.toArray(); 
        for (int i = 0; i < array.length; i++) {
            result[i] = (int) array[i];
        }
        
        return result;

    }
}