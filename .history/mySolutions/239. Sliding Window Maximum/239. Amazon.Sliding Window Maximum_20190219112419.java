class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[]{};
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int length = nums.length - k + 1;
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        results.add(pq.peek());

        for (int i = 1; i < length; i++) {
            pq.remove(nums[i - 1]);
            pq.add(nums[i + k - 1]);
            
            results.add(pq.peek());
        }

        int[] resultsToArray = new int[results.size()];
        for (int i = 0; i < results.size(); i++) {
            resultsToArray[i] = results.get(i);
        }

        return results;
    }
}