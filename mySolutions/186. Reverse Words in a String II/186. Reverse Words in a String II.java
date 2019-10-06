class Solution {
    public void reverseWords(char[] s) {
        if (s.length <= 1) {
            return;
        }
        
        reverse(s, 0, s.length - 1);
        
        for (int left = 0; left < s.length; left++) {
            
            int right = left;
            for (; right + 1 < s.length && s[right + 1] != ' '; right++) {}
            reverse(s, left, right);
            left = right + 1;
        }
        
    }
    
    private void reverse(char[] s, int left, int right) {
        while (left < right) {
            char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            left++; right--;
        }
        
    }
}