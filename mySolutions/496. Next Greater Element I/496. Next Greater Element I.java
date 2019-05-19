class Solution {
    
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        
        Map<Integer, Integer> numMapIndexOfNums2 = new HashMap<>();
        
        int[] result = new int[nums1.length];
                
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            numMapIndexOfNums2.put(num, i);
        }
        
        for (int i = 0; i < result.length; i++) {
            int index = numMapIndexOfNums2.get(nums1[i]);
            
            result[i] = getNextGreaterElement(nums2, index);
        }
        
        return result;
    }
    private int getNextGreaterElement(int[] arr, int index) {
        int nextGreater = -1;
        
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] < arr[i]) {
                nextGreater = arr[i];
                break;
            }
        }
        
        return nextGreater;
    }
}