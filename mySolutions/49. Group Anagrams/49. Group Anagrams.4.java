class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String ana = String.valueOf(arr);
            if (!map.containsKey(ana)) {
                List<String> gp = new ArrayList<>();
                map.put(ana, gp);
                res.add(gp);
            }
            map.get(ana).add(strs[i]);
        }
        
        
        return res;
    }
}