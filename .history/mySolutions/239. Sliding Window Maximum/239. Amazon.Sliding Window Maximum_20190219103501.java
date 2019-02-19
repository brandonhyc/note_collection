class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public Integer compare(Integer a, Integer b) {
                return (Integer) (b - a);
            }
        });

        return new int[]{};
    }
}