class Solution {
    public int numJewelsInStones(String J, String S) {
        
        Set<Integer> set = new HashSet<>();
        int count = 0;
        
        for (Character c : J.toCharArray()) {
            set.add(c - 'a');
        }
        
        for (Character c : S.toCharArray()) {
            if (set.contains(c - 'a')) {
                count++;
            }
        }
        
        return count;
    }
}