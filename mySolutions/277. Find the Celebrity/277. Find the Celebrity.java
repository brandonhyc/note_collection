import java.util.Set;

/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int countOne = 0;

            for (int j = 0; j < n; j++) {
                if (knows(i, j)) {
                    countOne++;
                }
            }
            if (countOne == 1) {
                set.add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            int countOne = 0;

            for (int j = 0; j < n; j++) {
                if (knows(j, i)) {
                    countOne++;
                }
            }
            if (countOne == n) {
                if (set.contains(i)) {
                    return i;
                }
            }
        }

        return -1;
    }
}