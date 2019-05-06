class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int right = 0;
        
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        
        while (left < s.length() && right < s.length()) {
            char c = s.charAt(right);
            if (left < right && set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            else if (!set.contains(c) || (left == right && set.contains(c))) {
                set.add(c);
                right++;
            }
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}