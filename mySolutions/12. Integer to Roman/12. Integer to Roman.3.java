class Solution {
    public String intToRoman(int num) {
        int[] nums = new int[]{      1000, 900, 500, 400, 100,   90,  50, 40, 10, 9, 5, 4, 1 };
        String[] rms = new String[]{ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(rms[i]);
            }
            i += 1;
            
        }
        
        return sb.toString();
    }
}