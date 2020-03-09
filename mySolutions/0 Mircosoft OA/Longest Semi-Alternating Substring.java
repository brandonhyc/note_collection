// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(maxSemiAtninStr("baaabbabbb")); // 7
        System.out.println(maxSemiAtninStr("babba")); // 5
        System.out.println(maxSemiAtninStr("abaaaa"));// 4
        System.out.println(maxSemiAtninStr("a")); // 1

    }

    static private int maxSemiAtninStr(String str) {
        int l = 0, r = 0, maxLen = 0;
        while (r < str.length()) {
            char ch = str.charAt(r);
            int same = 0;
            for (int i = 1; i < 3; i++) {
                if (r - i >= 0 && str.charAt(r) == str.charAt(r - i))
                    same += 1;
                if (same == 2)
                    l = r - 1; // having 3 depulicate
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r += 1;
        }
        return maxLen;
    }
}