Solution:
Step1, from right to left, find the first number which not increase in a ascending order. In this case which is 3.
Step2, here we can have two situations:

We cannot find the number, all the numbers increasing in a ascending order. This means this permutation is the last permutation,
we need to rotate back to the first permutation. So we reverse the whole array, for example, 6,5,4,3,2,1 we turn it to 1,2,3,4,5,6.

We can find the number, then the next step, we will start from right most to leftward, try to find the first number which is larger than 3, in this case it is 4.
Then we swap 3 and 4, the list turn to 2,4,6,5,3,1.
Last, we reverse numbers on the right of 4, we finally get 2,4,1,3,5,6.

Time complexity is: O(3*n)=O(n).


class Solution {
    public void nextPermutation(int[] nums) {
        
        // [], [0], [1,2]
        //     654231
        // 1. 往左找转折， 若无转一次，找大点
        // 2. 若有则转两次
        if (nums.length <= 1) {
            return;
        }
        
        int left = 0;
        for (left = nums.length - 2; left >= 0; left--) {
            if (nums[left] < nums[left + 1]) {
                break;
            }
        }

        // System.out.printf("left: %d\n", left);
        if (left == -1) {
            swapInBetween(nums, 0, nums.length - 1);
        } else {
            int right = 0;
            for (right = nums.length - 1; right >= 0 ; right--) {
                if (nums[left] < nums[right]) {
                    break;
                }
            }        
            
            // System.out.printf("got left: %d, right: %d\n", left, right);
            // 转两点
            swap(nums, left, right);
            System.out.println(Arrays.toString(nums));
            
            swapInBetween(nums, left + 1, nums.length - 1); 
            
        }
        
            
    }
    
    private void swap(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
            
    }
    
    private void swapInBetween (int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            // System.out.println(Arrays.toString(nums));
            left++; right--;
        }
        
    }
}