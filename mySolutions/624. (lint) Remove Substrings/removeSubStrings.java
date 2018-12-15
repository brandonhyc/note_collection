public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // write your code here

        


    }

    public Set<String> indexes(String s, String d, Set<String> set) {
        Set<String> result = new HashSet<>();
        
        int index = -1;
        while ((index = s.indexOf(d, index + 1)) != -1) {
            StringBuilder sb = new StringBuilder(s);
            sb.delete(index, index + d.length());
            if (set.contains(sb.toString())) {
                continue;
            }
            result.add(sb.toString());
        }
        return result;
    }
    
}