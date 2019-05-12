class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // edge case: 0, 0 / nums1 or nums2 first end/ 
        
        List<Integer> result = new ArrayList<>();
        
        int left = 0; 
        int right = 0;
        
        while (left < m && right < n) {
            
            if (nums1[left] <= nums2[right]) {
                result.add(nums1[left]);
                left++;
            }
            else if (nums1[left] > nums2[right]) {
                result.add(nums2[right]);
                right++;
            }
        }
        
        while (left < m) {
            result.add(nums1[left]);
            left++;
        }
        
        while (right < n) {
            result.add(nums2[right]);
            right++;
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result.get(i);
        }
        
    }
}