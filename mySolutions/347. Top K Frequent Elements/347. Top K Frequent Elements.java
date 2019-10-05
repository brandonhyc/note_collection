class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int num : nums) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        List<Integer>[] frequences = new ArrayList[nums.length + 1];
        
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (frequences[count] == null) {
                frequences[count] = new ArrayList<Integer>();
            }
            frequences[count].add(key);
        }
        
        List<Integer> results = new ArrayList<>();
        
        for (int i = frequences.length - 1; k > 0 && i >= 0; i--) {
            if (frequences[i] == null) {
                continue;
            }
            int size = frequences[i].size();
            k = k - size;
            results.addAll(frequences[i]);
        }
        
        return results;
    }
}