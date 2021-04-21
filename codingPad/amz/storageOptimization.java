package codingPad.amz;

import java.util.Collections;
import java.util.List;

public class storageOptimization {

    public static int storageOptimization(int n, int m, List<Integer> h, List<Integer> v) {
        Collections.sort(h);
        Collections.sort(v);

        int maxWidth = getMaxGap(h);
        int maxHeight = getMaxGap(v);

        return maxWidth * maxHeight;
    }

    private static int getMaxGap(List<Integer> gap) {
        int maxGap = 0;
        int i = 0;
        while (i < gap.size()) {
            int j = i;
            while (j + 1 < gap.size() && gap.get(j + 1) == gap.get(j) + 1) {
                j++;
            }
            maxGap = Math.max(maxGap, j - i + 2);

            i = j + 1;
        }
        return maxGap;
    }
}
