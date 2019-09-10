class Solution {
    public String longestCommonPrefix(String[] strs) {

        
        if (strs.length == 0) {
            return "";
        }
        
        String longest = strs[0];
        
        for (int i = 0; i < strs.length; i++) {
            
            String can = strs[i];
            
            while (can.indexOf(longest) != 0) {
                longest = longest.substring(0, longest.length() - 1);
            }
            
        }
        
        return longest;
    }
}