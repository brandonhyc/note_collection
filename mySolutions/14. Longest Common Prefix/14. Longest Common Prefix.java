class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 0) {
            return "";
        }
        
        String longest = strs[0];
        
        int i = 0;
        
        while (i < strs.length) {
            while (strs[i].indexOf(longest) != 0) {
                    longest = longest.substring(0, longest.length() - 1);
            }
            i++;
        }
        
        return longest;
    }
}