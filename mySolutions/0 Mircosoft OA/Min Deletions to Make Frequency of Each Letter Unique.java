// "static void main" must be defined in a public class.
//https://leetcode.com/discuss/interview-question/398035/
public class Main {
    public static void main(String[] args) {
        System.out.println(minDeletion("eeeeffff")); // 1
        System.out.println(minDeletion("aabbffddeaee")); // 6
        System.out.println(minDeletion("llll")); // 0
        System.out.println(minDeletion("aaaabbbb")); // 1
        System.out.println(minDeletion("aabbbbcccdddd")); // 3
        System.out.println(minDeletion("aaaaaabbbbbccccddddeeeeee")); // 5
        System.out.println(minDeletion("abcdefghijkl")); //11
        System.out.println(minDeletion("aaaaaa")); // 0

    }
    
    static private int minDeletion(String str) {
        int[] counts = new int[26];
        for (char ch : str.toCharArray()) {
            counts[ch - 'a'] += 1;
        }
        int deletions = 0;
        Set<Integer> set = new HashSet<>(); // store appearance times
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] != 0) {
                if (set.add(counts[i])) break;
                counts[i] -= 1;
                deletions += 1;
            }
        }
        return deletions;
    }
}