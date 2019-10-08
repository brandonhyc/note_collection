class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // more to right
        int left = m - 1;
        int right = nums1.length - 1;
        while (left >= 0) {
            nums1[right] = nums1[left];
            
            left--;
            right--;
        }
        
        
        int ptr1 = nums1.length - m;
        int ptr2 = 0;
        int smaller = 0;
        while (ptr1 < nums1.length || ptr2 < nums2.length) {
            int num1 = ptr1 < nums1.length ? nums1[ptr1] : Integer.MAX_VALUE;
            int num2 = ptr2 < nums2.length ? nums2[ptr2] : Integer.MAX_VALUE;
            
            if (num1 < num2) {
                nums1[smaller] = num1;
                ptr1++;
            } else {
                nums1[smaller] = num2;
                ptr2++;
            }
            
            smaller++;
        }
        
        
    }
}