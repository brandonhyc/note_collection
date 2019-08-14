class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('M', 1000);
                put('D', 500);
                put('C', 100);
                put('L', 50);
                put('X', 10);
                put('V', 5);
                put('I', 1);
            }
        };

        int result = 0;
        result += map.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {

            if (map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
                result = result - 2 * map.get(s.charAt(i - 1));
            }

            result += map.get(s.charAt(i));
        }

        return result;
    }
}