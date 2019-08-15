class Solution {
    public String intToRoman(int num) {

        String[] chars = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] nums = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < nums.length; i++) {

            int unit = nums[i];
            while (num >= unit) {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}