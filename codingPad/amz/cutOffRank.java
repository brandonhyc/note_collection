package codingPad.amz;

import java.util.Collections;
import java.util.List;

public class cutOffRank {
    public int cutOffRank(int cutOff, List<Integer> scores) {
        Collections.sort(scores, (x, y) -> Integer.compare(y, x));

        int endIdx = cutOff;

        while (endIdx < scores.size() && scores.get(endIdx - 1) == scores.get(endIdx)) {
            endIdx++;
        }

        return endIdx;
    }
}
