class Solution {
    public String convertToTitle(int n) {

52

        String result = "";
        int rest = n;

        while (rest / 27 != 0) {
            result = result + (char) (rest / 26 + 'A' - 1);
            rest = rest % 26;
        }
        result = result + (char) (rest + 'A' - 1);

        return result;
    }
}