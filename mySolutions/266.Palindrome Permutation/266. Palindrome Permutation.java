class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (set.contains(ch)) {
                set.remove(ch);
            } else {
                set.add(ch);
            }
        
        }
        
        return set.size() <= 1;
    }
}