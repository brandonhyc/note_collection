class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int counter1 = 0;
        int counter2 = 0;
        int zeros = 0;
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros = (zeros + 1) % 2;
                if (zeros == 1) {
                    counter1 += 1;
                    counter2 = 0;
                }
                else {
                    counter2 += 1;
                    counter1 = 0;
                }
            } else {
                counter1 += 1;
                counter2 += 1;
            }
            
            max = Math.max(counter1, max);
            max = Math.max(counter2, max);
        }
        
        return max;
    }
}