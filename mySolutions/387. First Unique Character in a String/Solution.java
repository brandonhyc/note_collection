public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        int[] record = new int[256];
        char result = '0';

        for (int i = 0; i < str.length(); i++) {
            
            char c = str.charAt(i);
            record[c]++;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (record[c] == 1) {
                result = c;
                break;
            }
        }
        
        return result;

    }
}