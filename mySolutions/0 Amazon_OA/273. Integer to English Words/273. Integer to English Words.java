class Solution {
    
    
    String[] NUM_1_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"}
    String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
    
        res = new StringBuilder()
        ths = 0

        while (num != 0) {
            res = helper(num % 1000) + THOUSANDS[ths] + res

            num = num / 1000;
            ths += 1;
        }


        return res.toString();
    }

    private helper(int num) {
        StringBuilder sb = "";
        int hundred = num / 100;

        if (hundred != 0) {
            sb += ONES[num] + "HUNDRED"
        }
        
        num = num % 100

        if (num < 20) {
            sb += NUM_1_20[num]
        } else {
            int ten = num / 10
            sb = TENS[ten] + NUM_1_20[num % 10] + sb
        }

        return sb.toString();
    }
}