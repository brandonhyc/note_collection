public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching
     *          string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        Map<Character, String> map = new HashMap<Character, String>();
        String[] arrOfStr = teststr.split(" ");

        if (teststr.length() == 0 || pattern.length() == 0) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {

            if (!map.containsKey(pattern.charAt(i))) { 
                if (map.containsValue(arrOfStr[i])) {
                    return false; 
                }
                map.put(pattern.charAt(i), arrOfStr[i]);
            }
            if (!map.get(pattern.charAt(i)).equals(arrOfStr[i])) {
                return false;
            }
        }
        return true;
    }
}