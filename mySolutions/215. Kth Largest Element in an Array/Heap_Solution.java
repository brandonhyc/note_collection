public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // write your code here

        if (nums == null || nums.length == 0){
            return null;
        }

        heapify(nums);  

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = nums[i];
        }

        return result;

    }

    private void heapify(int[] nums) {
        int size = nums.length;
        for (int i = size / 2; i >=0; i--) {
            siftDown(nums, i);
        }
    }

    private void siftDown(int[] nums, int index) {
        while (index < nums.length) {
            int max = index;
            int left = index * 2 + 1;
            int right = index * 2 + 2;

            if (left < nums.length &&
                nums[max] < nums[left]) {
                max = left;
            }
            if (right < nums.length && 
                nums[max] < nums[right]) {
                    max = right;
            }
            if (max != index) {
                int temp = nums[max];
                nums[max] = nums[index];
                nums[index] = temp;

                index = max;
            } else {
                break;
            }
        }
    }
    

}