class Solution {
    public boolean canJump(int[] nums) {
        
        boolean[] visited = new boolean[nums.length];
        
        return canJumpDfs(nums, visited, 0, nums.length - 1);
    }
    
    private boolean canJumpDfs(int[] nums, boolean[] visited, int from, int to) {
        if (from < 0 || from >= nums.length) {
            return false;
        }
        if (visited[from]) {
            return false;
        }
        visited[from] = true;
        
        int left = from - nums[from];
        int right = from + nums[from];
        
        if (left <= to && to <= right) {
            System.out.printf("here is %d, to: %d, left: %d, right: %d", from, to, left, right);
            return true;
        }
        
        boolean result = false;
        
        
        for (int i = 0; i < nums.length; i++) {
            if (i < left || i > right) {
                continue;
            }
            result = result || canJumpDfs(nums, visited, i, to);
        }
        
        return result;
    }
}