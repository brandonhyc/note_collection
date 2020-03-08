// https://leetcode.com/discuss/interview-question/366869/
// https://leetcode.com/playground/reRWGJPB
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(removeOne("abczd")); // abcd 
        System.out.println(removeOne("abcde")); // abcd
    }
    
    static private String removeOne(String str) {
        if (str.length() == 0) return "";
        StringBuilder sb = new StringBuilder(str);
        int i = 0;
        while(i < sb.length() - 1) {
            if (sb.charAt(i) > sb.charAt(i + 1)) break;
            i += 1;
        }
        return sb.deleteCharAt(i).toString();
    }
}