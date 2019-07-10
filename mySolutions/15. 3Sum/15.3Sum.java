class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) { // dedupes 
                int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
                
                while (lo < hi) {
                    if (sum == nums[lo] + nums[hi]) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    }
                    if (nums[lo] + nums[hi] < sum) {
                        lo++;
                    } else {
                        hi--;
                    }                  
                }
                

            }
            else if (nums[i] == nums[i - 1]) {
                continue;
            }
            
        }
        
        return res;
    }
}