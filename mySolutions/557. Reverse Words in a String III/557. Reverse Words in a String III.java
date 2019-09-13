class Solution {
    public String reverseWords(String s) {
        
        char[] arr = s.toCharArray();
        
        
        for (int left = 0; left < arr.length; left++) {
            
            if (arr[left] == ' ') {
                continue;
            }
            int right = left;
            while (right + 1 < arr.length && arr[right + 1] != ' ') {
                right++;
            }
            
            reverse(arr, left, right);
            left = right;
        }
        
        return new String(arr);
    }
    
    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; right--;
        }
        
    }
}