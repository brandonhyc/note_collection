class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder(num);
        
        for (int i = 0; i < k; i ++) {
            int j = 0;
            for (; j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1); j ++);
            sb.delete(j, j + 1);
            
        }
        int nonzero = 0;
        for (; nonzero < sb.length()&& sb.charAt(nonzero) == '0'; nonzero += 1);
        String res = sb.substring(nonzero).toString();
        return res.length() == 0 ? "0" : res;
    }
}