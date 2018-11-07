public class Solution {
    /**
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */

    boolean test = true;
    public boolean search(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return false;
        }

        int start = 0, end = nums.length - 1;
                    /************COPY HERE**************/        
        if (test) {
            System.out.printf("%s, t: %d\n 0  1  2  3  4  5  6  7  8  9  10\n________________________________\nstart(i/v), mid, end\n",Arrays.toString(nums), target);
        }
        

        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (test) {
                binarySearchPrintHelper(nums, start, end, mid, target);
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[start] > nums[mid]) {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            System.out.printf("now, start: %d, end: %d", start, end);

            while (start + 1 < nums.length && nums[start] == nums[start + 1]) {
                start++;
            }
            while (end - 1 > 0 && nums[end] == nums[end - 1]) {
                end--;
            }
            System.out.printf("now, start: %d, end: %d", start, end);

        }
        if (nums[start] == target) {
            return true;
        }
        if (nums[end] == target) {
            return true;
        }
        return false;
    }

    public void binarySearchPrintHelper(int[] nums, int start, int end, int mid, int target) {
        // System.out.printf("start(i/v), mid, end\n%s\n", Arrays.toString(nums));

        if (nums[mid] == target) {
            System.out.printf("[%d]:%d | ([%d]:%d | [%d]:%d), get mid, mid to right\n", 
                                start, nums[start],
                                mid, nums[mid],
                                end, nums[end] );
        }
        if (nums[mid] < target) {
            System.out.printf("([%d]:%d | [%d]:%d) | [%d]:%d, mid to right\n", 
                                start, nums[start],
                                mid, nums[mid],
                                end, nums[end] );
        }
        if (nums[mid] > target) {
            System.out.printf("[%d]:%d | ([%d]:%d | [%d]:%d) left to mid\n", 
                                start, nums[start],
                                mid, nums[mid],
                                end, nums[end] );
        }

    }


}