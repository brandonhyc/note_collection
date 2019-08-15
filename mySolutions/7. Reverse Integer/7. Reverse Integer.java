class Solution {
    // wrong
    public int reverse(int x) {

        StringBuffer sb = new StringBuffer(x);
        if (x < 0) {
            sb = sb.substring(1, str.length);
            sb.revers();
            return -Integer.valueOf(sb.toString());

        } else {
            sb.reverse();
            return Integer.valueOf(sb.toString);
        }
    }
}