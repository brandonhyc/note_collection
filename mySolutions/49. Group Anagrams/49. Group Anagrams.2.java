class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            if (!map.containsKey(str)) {
                map.put(str, new ArrayList<String>());
            }
            map.get(str).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}