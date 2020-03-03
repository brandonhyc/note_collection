// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println(merge("HackerRank", "Monday"));
        System.out.println(merge("abc", "def"));
    }
    
    static private String merge(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int iA = 0;
        int iB = 0;
        while (iA < lenA && iB < lenB) {
            if (iA <= iB) {
                sb.append(a.charAt(iA));
                iA += 1;
            }
            else {
                sb.append(b.charAt(iB));
                iB += 1;
            }
        }
        
        while (iA < lenA) {
            sb.append(a.charAt(iA));
            iA += 1;
        }
        
        while (iB < lenB) {
            sb.append(b.charAt(iB));
            iB += 1;
        }
        return sb.toString();
    }
    
}