// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        String s1 = "aabab";
        String s2 = "dog";
        String s3 = "aa";
        String s4 = "baaa";
        String s5 = "aaba";
        System.out.println(addACount(s1));// 3
        System.out.println(addACount(s2));// 8
        System.out.println(addACount(s3));// 0
        System.out.println(addACount(s4));// -1
        System.out.println(addACount(s5));// 1
    }

    // only count
    static private int addACount(String str) {
        int newAs = 0;
        for (int i = 0; i < str.length() + 1; i++) {
            int aCount = 0;
            // extend if there is any 'a' already on the cursor, let it stop at somewhere
            // not 'a'
            while (i < str.length() && str.charAt(i) == 'a') {
                aCount += 1;
                i += 1;
            }
            if (aCount > 2)
                return -1;
            while (aCount < 2) {
                aCount += 1;
                newAs += 1;
            }
        }

        return newAs;
    }

    // new string
    static private int addA(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int newAs = 0;
        while (i < str.length() + 1) {
            int aCount = 0;
            // extend if there is any 'a' already on the cursor, let it stop at somewhere
            // not 'a'
            while (i < str.length() && str.charAt(i) == 'a') {
                sb.append('a');
                aCount += 1;
                i += 1;
            }
            if (aCount > 2)
                return -1;
            while (aCount < 2) {
                aCount += 1;
                sb.append('a');
                newAs += 1;
            }
            if (i < str.length()) {
                sb.append(str.charAt(i));
            }
            i += 1;
        }

        System.out.printf("new string: %s, sb.length(): %d \n", sb.toString(), sb.toString().length());
        return newAs;

    }

}