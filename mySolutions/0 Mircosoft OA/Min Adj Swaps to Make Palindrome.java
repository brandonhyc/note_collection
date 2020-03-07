// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(minStepToPalm("mamad")); // 3
        System.out.println(minStepToPalm("asflkj")); // -1
        System.out.println(minStepToPalm("aabb")); // 2
        System.out.println(minStepToPalm("ntiin")); // 1
    }
    
    static private int minStepToPalm(String str) {
        if (!canForm(str)) return -1;
        int n = str.length();
        int step = 0;
        StringBuilder sb = new StringBuilder(str);
        
        for (int i = 0; i < n / 2; i++) {
            // try to move char to left and right end
            // find a match from the right
            int j = n - 1 - i;
            for (; i < j && sb.charAt(i) != sb.charAt(j); j--);
            if (i != j && sb.charAt(i) == sb.charAt(j)) {
                // move it to symetry pos
                for (int k = j; k < n - 1 - i; k++) {
                    swap(sb, k, k + 1);
                    step += 1;
                }
            } else {
                // find an odd, move to the mid
                for (int k = i; k < n / 2; k++) {
                    swap(sb, k, k + 1);
                    step += 1;
                }
            }
            // System.out.printf("from: %s, to: %s\n", sb.toString(), str);
        }
        return step;
        
    }
    static private void swap(StringBuilder sb, int l, int r) {
        char temp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, temp);
    }
    
    static private boolean canForm(String str) {
        int[] chCounts = new int[26];
        for (char ch : str.toCharArray()) chCounts[ch - 'a'] += 1;
        int oddCounts = 0;
        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] % 2 != 0) oddCounts += 1;
        }
        if (str.length() % 2 == 0) {
            return oddCounts == 0;
        }
        // if len is odd number
        return oddCounts <= 1;
    }
    
}