public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        // write your code here

        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);

        int minmum  = Integer.MAX_VALUE,
            minLeft = -1, minRight = -1, minStart = -1;
    
        for (int start = 0; start < nums.length - 2; start++) {
            
            int left = start + 1, right = nums.length - 1;

            while (left < right) {
                int difference = nums[left] + nums[right] + nums[start] - target;
                int distance = Math.abs(difference);

                if (distance < minmum) {
                    minmum =  distance;

                    minLeft = left;
                    minRight = right;
                    minStart = start;
                    // System.out.printf("minmum: %d, left: %d, right: %d, start: %d, nums[left]: %d, nums[right]: %d, nums[start]: %d\n", 
                    //                 minmum, minLeft, minRight, minStart, nums[left], nums[right], nums[start]);
                }
                //[-15, -2, -1, 0, 0, 1, 2, 21] t: -20, r: -17 d: 3
                if (difference < 0) {
                    left++;

                    while (left < right && nums[left - 1] == nums[left] ) {
                        left++;
                    }
                } else {
                    right--;

                    while (left < right && nums[right + 1] == nums[right]) {
                        right--;
                        
                    }
                }
            }

            while (start + 1 < nums.length - 2 && nums[start] == nums[start + 1]) {
                start++;
            }
        }

        return nums[minLeft] + nums[minRight] + nums[minStart];
        /**
            
            int minmum = Integer.MAX_INTEGER, 
                minLeft = -1, minRight = -1;, 
            for start= 0 to nums.length - 2: 
                
                left = start + 1, right = nums.length - 1

                while (left < right) :
                    int difference = nums[left] + nums[right] + nums[start]  - target 
                    int distance =  math.abs difference
                    if (distance < minmum):
                        minmum = difference;
                        minLeft = left;
                        minright = right;
                    end if.

                    if (difference > 0):
                        right--
                        iterate right through same index 
                    else if :
                        left++
                        iterate right through same index 
                    end if.
                end while
                iterate start through same index 

        */              


    }
}