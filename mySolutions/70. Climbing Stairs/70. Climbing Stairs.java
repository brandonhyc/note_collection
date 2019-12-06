class Solution {
    public int climbStairs(int n) {
        // for each stairs 'n'
        //   1. create new set take one step if not excess, process the rest recursively  
        //   2. create new set take two steps if not excess, process the rest recursively
        // return all sets
        if (n <= 2) {
            return n;
        }
        
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        
        return n2;
    }
}