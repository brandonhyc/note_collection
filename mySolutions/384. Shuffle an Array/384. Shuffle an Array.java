class Solution {

    int[] array;
  
    public Solution(int[] nums) {
      array = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
      return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
      int[] res = array.clone();
      
      for (int i = 0; i < res.length; i++) {
        int left = i;
        int right = (int) (Math.random() * (res.length - 1 - i + 1)) + i; // 0 - rand.length - 1
        
        swap(res, left, right);
      }
      return res;
    }
  
    private void swap(int[] nums, int left, int right) {
      int temp = nums[left];
          nums[left] = nums[right];
          nums[right] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */