```java
public class Solution {

        /************COPY HERE**************/
    boolean test = false;

    public int lastPosition(int[] nums, int target) {

        int start = 0, end = nums.length - 1;

            /************COPY HERE**************/        
        if (test) {
            System.out.printf("%s, t: %d\n 0  1  2  3  4  5  6  7  8  9  10\n________________________________\nstart(i/v), mid, end\n",Arrays.toString(nums), target);
        }
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2;

            /************COPY HERE**************/
            if (test) {
                binarySearchPrintHelper(nums, start, end, mid, target);
            }

        }
    }

            /************COPY HERE**************/
    public void binarySearchPrintHelper(int[] nums, int start, int end, int mid, int target) {
        // System.out.printf("start(i/v), mid, end\n%s\n", Arrays.toString(nums));

        if (nums[mid] == target) {
            System.out.printf("[%d]:%d|([%d]:%d|[%d]:%d), get mid, mid to right\n", 
                                start, nums[start],
                                mid, nums[mid],
                                end, nums[end] );
        }
        if (nums[mid] < target) {
            System.out.printf("([%d]:%d|[%d]:%d)| [%d]:%d, mid to right\n", 
                                start, nums[start],
                                mid, nums[mid],
                                end, nums[end] );
        }
        if (nums[mid] > target) {
            System.out.printf("[%d]:%d|([%d]:%d|[%d]:%d) left to mid\n", 
                                start, nums[start],
                                mid, nums[mid],
                                end, nums[end] );
        }

    }
}
```