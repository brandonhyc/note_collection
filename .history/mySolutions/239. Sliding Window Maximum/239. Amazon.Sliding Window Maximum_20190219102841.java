class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(int a, int b) {
                return (int) (b - a);
            }
        });

        return new int[]{};
    }
}