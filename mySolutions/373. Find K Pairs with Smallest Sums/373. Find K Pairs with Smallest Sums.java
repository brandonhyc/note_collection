class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return new ArrayList<>();
        }
        
        PriorityQueue<int[]> minheap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        List<List<Integer>> results = new ArrayList<>();
        
        for (int i = 0; i < nums1.length; i++) {
            minheap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k != 0 && minheap.size() != 0) {
            int[] pair = minheap.poll();
            results.add(Arrays.asList(pair[0], pair[1]));
            
            int indexNum2 = pair[2] + 1;
            if (indexNum2 != nums2.length) {
                minheap.offer(new int[]{pair[0], nums2[indexNum2], indexNum2});
            }
            
            k -= 1;
        }
        
        return results;
        
    }
}