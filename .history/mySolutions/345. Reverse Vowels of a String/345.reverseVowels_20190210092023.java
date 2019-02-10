class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String vowels = "aeiouAEIOU";

        int left = 0, right = s.length() - 1;
        while (left < right) {
            char lc = s.charAt(left);
            char rc = s.charAt(right);
            if (vowels.indexOf(lc) != -1 && 
                vowels.indexOf(rc) != -1) {
                reverse(s, left, right);
                left++;
                right--;
                continue;
            }
            if (vowels.indexOf(lc) != -1) {
                right--;
            }
            if (vowels.indexOf(rc) != -1) {
                left++;
            }
        }
    }

    private void reverse(String s, int left, int right) {
        char[] arr = s.toCharArray();

        int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        
        s = arr.toString();
    }
}