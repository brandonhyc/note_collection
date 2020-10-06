public class Solution {
    public String[] combinations(int number) {
        if (number <= 0) {
            return new String[]{""};
        }
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "");
        map.put(1, "");
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> res = new ArrayList<>();
        allCombs(number, new StringBuilder(), res, map);

        String[] array = new String[res.size()];
        for (int i = 0; i < array.length; i++) array[i] = res.get(i);
        Arrays.sort(array);
        return array;
    }

    private void allCombs(int number, StringBuilder curr, List<String> res, Map<Integer, String> map) {
        if (number == 0) {
            res.add(curr.toString());
            return;
        }

        // recursive rule
        String pad = map.get(number % 10);
        if (pad.length() == 0) {
            allCombs(number / 10, curr, res, map);
        } else {
            for (int i = 0; i < pad.length(); i++) {
                curr.insert(0, pad.charAt(i));
                allCombs(number / 10, curr, res, map);
                curr.deleteCharAt(0);
            }
        }

    }
}
