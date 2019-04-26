class Solution {
    int minSteps;
    public int jump(int[] nums) {
        
        if (nums.length == 1) {
            return 0;
        }
        
        int[] movedSteps = new int[nums.length];
        
        for (int i = 0; i < movedSteps.length; i++) {
            movedSteps[i] = Integer.MAX_VALUE;
        }
        
        List<Integer> path = new ArrayList<>();
        
        minSteps = Integer.MAX_VALUE;
        
        dfs(nums, movedSteps, 0, nums.length - 1, path);
        
        return minSteps;
    }
    
    private void dfs(int[] nums, int[] movedSteps, int from, int to, List<Integer> path) {
        if (from < 0 || from >= nums.length) {
            return;
        }
        if (movedSteps[from] <= path.size()) {
            return;
        }
        movedSteps[from] = path.size();
        
        int left = from;
        int right = Math.min(nums.length - 1, from + nums[from]);
        
        if (left <= to && to <= right) {
            minSteps = Math.min(minSteps, path.size() + 1);
            return;
        }
        
        for (int i = left; i <= right; i++) {
            path.add(i);
            dfs(nums, movedSteps, i, to, path);
            path.remove(path.size() - 1);
        }
        
        return;
    }
}