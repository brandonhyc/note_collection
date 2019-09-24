class Solution {
    public String convertToTitle(int n) {
        
        StringBuilder sb = new StringBuilder();
        int dividend = n;
        while (dividend != 0) {
            dividend--;
            int remainder = dividend % 26;
            dividend = dividend / 26;
            
            sb.insert(0, (char)(remainder + 'A'));
        }
        
        return sb.toString();
    }
}