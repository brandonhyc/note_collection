class Solution {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length);
        
        int l = 0;
        
        for (; l < s.length; ) {
            // trim left
            for (; l < s.length && s[l] == ' '; l++); 
            
            // parse a word
            int r = l + 1; 
            for (; r < s.length && s[r] != ' '; r++); 
            
            reverse(s, l, r);
            // System.out.printf("%s, l: %d, r: %d, \n", Arrays.toString(s), l, r);
            l = r;
        }
        
    }
    
    private void reverse(char[] chars, int l, int r) {
        r -= 1;
        while (l < r) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
            l += 1;
            r -= 1;
        }
    }
}