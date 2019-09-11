class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        
        if (s.length() == 0) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        
        
        for (int i = 0; i < s.length() && i + 1 < s.length(); i++) {
            char[] arr = s.toCharArray();
            
            int j = i;
            if (j + 1 < s.length() && arr[j] == '+' && arr[j + 1] == '+') {
                arr[j] = '-';
                arr[j + 1] = '-';
                result.add(new String(arr));
            }
            
        }
        
        return result;
        
    }
}