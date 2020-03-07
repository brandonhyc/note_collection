// "static void main" must be defined in a public class.
// https://leetcode.com/discuss/interview-question/398031/
// Given a string s containing only a and b, find longest substring of s such that s does not contain more than two contiguous occurrences of a and b
public class Main {
    public static void main(String[] args) {
        System.out.println(LessThan2dupl("aa")); // aa
        System.out.println(LessThan2dupl("aabbaaaaabb")); // aabbaa
        System.out.println(LessThan2dupl("aabbaabbaabbaa")); // aabbaabbaabbaa
        System.out.println(LessThan2dupl("abbaabbaaabbaaa"));// "abbaabbaa"
        
    }
    
    static private String LessThan2dupl(String str) {
        int maxLen = 0;
        int maxLeft = 0;
        int l = 0, r = 0, n = str.length();
        for (; l < n; l = r) {
            int count = 0;
            for (; r < n; r += 1) {
                if (r - 1 >= 0 && str.charAt(r - 1) == str.charAt(r)) count += 1;
                else count = 0;
                if (count == 2) break;
            }
            int curLen = -1;
            curLen += r - l + 1;
            
            if (curLen > maxLen) {
                maxLeft = l;
                maxLen = curLen;
            }
        }
        return str.substring(maxLeft, maxLen + maxLeft);
    }
}
