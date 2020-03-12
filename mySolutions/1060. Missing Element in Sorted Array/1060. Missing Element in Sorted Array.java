class Solution {
    public int missingElement(int[] nums, int k) {
        
        if (nums.length == 0) return -1;
        
        int l = 0, r = nums.length - 1;
        int missed =  (nums[r] - nums[l] + 1) - (r - l + 1) ;
        if (k > missed) return k - missed + nums[r];
        
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            missed = (nums[m] - nums[l] + 1) - (m - l + 1); // all missing of [l, m]
            if (missed >= k) r = m;
            else if (missed < k) {
                k -= missed;
                l = m;
            }
        }
        
        return nums[l] + k;
    }
}

// 4,7,9,10
// l m    r
//   l m  r
// missed = 7 - 4 - 1 - 0 = 2
// take right half [7, 10]

// missed = 9 - 7

