class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        if (letters[letters.length - 1] <= target) {
            return letters[0];
        }
        
        int left = 0;
        int right = letters.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] == target) {
                left = mid + 1;
            } else if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] > target){
                right = mid;
            }            
        }
        
        return letters[left];
    }
}