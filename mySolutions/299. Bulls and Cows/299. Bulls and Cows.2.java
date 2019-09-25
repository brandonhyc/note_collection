class Solution {
    public String getHint(String secret, String guess) {

        int[] nums = new int[10];
        int bull = 0;
        int cow = 0;

        for (int i = 0; i < secret.length(); i++) {
            int secrectCh = Character.getNumericValue(secret.charAt(i));
            int guessCh = Character.getNumericValue(guess.charAt(i));

            if (secrectCh == guessCh) {
                bull++;
            } else {
                if (nums[secrectCh] > 0) {
                    cow++;
                }
                if (nums[guessCh] < 0) {
                    cow++;
                }
                nums[secrectCh]--;
                nums[guessCh]++;
            }
        }

        return bull + "A" + cow + "B";
    }
}