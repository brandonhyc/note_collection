class Solution {

    String[] NUM_1_20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    String[] TENS = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    String[] THOUSANDS = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        String res = "";
        int ths = 0;

        while (num != 0) {
            if (num % 1000 != 0) {
                res = helper(num % 1000) + THOUSANDS[ths] + " " + res;
            }

            num = num / 1000;
            ths += 1;
        }

        return res.trim();
    }

    private String helper(int num) {
        String sb = "";
        if (num == 0) {
            sb = "";
        } else if (num < 20) {
            sb = NUM_1_20[num] + " ";
        } else if (num < 100) {
            sb = TENS[num / 10] + " " + helper(num % 10);
        } else {
            sb = NUM_1_20[num / 100] + " Hundred " + helper(num % 100);
        }

        return sb;
    }
}