class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        
        
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resultList = new ArrayList<>();
        
        for (int num: nums1) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }
        
        for (int num: nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                resultList.add(num);
            }
        }
        
        int[] result = new int[resultList.size()];
        int i = 0;
        for (Integer num: resultList) {
            result[i] = num;
            i++;
        }
        return result;
    }
}