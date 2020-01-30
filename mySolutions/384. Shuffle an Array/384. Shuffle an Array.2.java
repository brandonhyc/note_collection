class Solution {

    int[] cards = new int[]{};
    int[] current = new int[]{};
    Random rand = new Random();
    public Solution(int[] nums) {
        this.cards = nums;
        this.current = this.cards.clone();
        this.rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        current = this.cards.clone();
        return current;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = 0; i < this.current.length; i++) {
            int swapPos = rand.nextInt(this.current.length);
            
            int temp = this.current[i];
            this.current[i] = this.current[swapPos];
            this.current[swapPos] = temp;
        }
                
        return current;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */