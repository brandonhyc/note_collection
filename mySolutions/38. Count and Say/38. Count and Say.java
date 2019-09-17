class Solution {
    public String countAndSay(int n) {
//         1 1
//         2  11
//         3  21
//         4  1211
        
        if (n == 1) {
            return "1";
        }
        
        String lastSequence = countAndSay(n - 1); 
        StringBuilder sb = new StringBuilder();
        
        for (int left = 0; left < lastSequence.length(); left++) {
            
            char say = lastSequence.charAt(left);
            int count = 1;
            
            while (left + 1 < lastSequence.length() 
                   && lastSequence.charAt(left) == lastSequence.charAt(left + 1)) {
                left++;
                count++;
            }
            
            sb.append(count);
            sb.append(say);
            
        }
        
        
        return sb.toString();
    }
}