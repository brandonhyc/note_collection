class Solution {
    public int firstUniqChar(String s) {
        int[] indexs = new int[26];
        Arrays.fill(indexs, -1);
        
        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i) - 'a';
            if (indexs[j] == -1) indexs[j] = i;
            else if (indexs[j] != -1) indexs[j] = -2;
            
        }
        
        int found = Integer.MAX_VALUE;
        for (int i = 0; i < indexs.length; i++) {
            
            if (indexs[i] >= 0) found = Math.min(found, indexs[i]);
        }
        
        return found == Integer.MAX_VALUE ? -1 : found;
        
    }
}