class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> results = new ArrayList<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String keyStr = String.valueOf(arr);
            List<String> list = map.get(keyStr);

            if (list == null) {
                list = new ArrayList<String>();
                map.put(keyStr, list);
                results.add(list);
            }

            list.add(str);
        }

        return results;
    }
}