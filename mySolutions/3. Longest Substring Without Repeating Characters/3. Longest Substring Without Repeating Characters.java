class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        String maxStr = "";
        
        for (int i = 0; i < s.length(); i++) {
            String str = "";
            
            for (int j = i; j < s.length(); j++) {
                char nc = s.charAt(j);
                if (i != j && str.indexOf(nc) != -1) {
                    break;
                }
                
                str = str + s.charAt(j);
                
                if (str.length() > maxStr.length()) {
                    maxStr = str + "";
                }
            }
        }
        System.out.print(maxStr);
        return maxStr.length();
    }
}