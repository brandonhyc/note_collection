// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String str = "bab";
        System.out.printf("str: %s, ans: %s\n", str, breakPaldm(str));
        str = "acca";
        System.out.printf("str: %s, ans: %s\n", str, breakPaldm(str));
        str = "aaa";
        System.out.printf("str: %s, ans: %s\n", str, breakPaldm(str));
    }
    
    
    static private String breakPaldm(String pal) {
        
        int len = pal.length();
        char[] arr = pal.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            if (arr[i] == 'a') continue;
            if (arr[i] > 'a') arr[i] = 'a';
            return new String(arr);
        }
        
        
        return "IMPOSSIBLE";
    }
}