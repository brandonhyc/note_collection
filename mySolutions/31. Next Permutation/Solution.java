// 思路: 算法得记住. 先由右至左遍历找出峰值位置 i, 再次右左遍历, 求出 [j] > [i - 1], 并调换.
//  最后旋转 >= i 的所有值

// 易错点1: while 很容易出错. 所以每次读取array, 必须先定好boundry

// 相关练习: 1. 排序数组求峰值(二分法) 2. nextPermuation I&II 


public class Solution {
    /**
     * @param nums: An array of integers
     * @return: nothing
     */
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return;
        }
        
        int len = nums.length;
        int i = len - 1, j = len - 1;

        while (i > 0) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
            i--;
        }

        while (i > 0 && j > i - 1) {
            if (nums[i - 1] < nums[j]) {
                swap(nums, i - 1, j);
                break;
            } 
            j--;
        }
        
        System.out.printf("len = %d, i = %d, j = %d\n",len, i, j);
        
        int left = i, right = len - 1;
        while (left < right) {
            swap(nums, left, right);
            left++; right--;
        }
    }
    private void swap(int[] nums, int i, int j) {
        System.out.printf("// swaping %d, %d", i, j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}