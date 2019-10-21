class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums2);
        
        Set<Integer> resultSet = new HashSet<>();
        
        for (int num: nums1) {
            if (foundInArray(nums2, num)) {
                resultSet.add(num);
            }
        } 
        
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (Integer num : resultSet) {
            result[i] = num;
            i++;
        }
        
        return result;
    }
    
    private boolean foundInArray(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true; 
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
        }
        
        return nums[right] == target;
    }
}