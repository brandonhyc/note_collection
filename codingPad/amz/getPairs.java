package codingPad.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class getPairs {

    public static List<List<Integer>> getPairs(List<List<Integer>> b, List<List<Integer>> a, int target) {

        Collections.sort(a, (A, B) -> {
            int cp = Integer.compare(A.get(1), B.get(1));
            if (cp != 0) return cp;
            return Integer.compare(A.get(0), B.get(0));
        });

        List<List<Integer>> res = new ArrayList<>();
        Integer closest = null;
        for (List<Integer> pairB : b) {
            int bId = pairB.get(0), bVal = pairB.get(1);
            int aIdx = search(a, target - bVal);
            if (aIdx != -1) {
                int aVal = a.get(aIdx).get(1);
                int newSum = aVal + bVal;
                if (closest == null || target - newSum < target - closest) {
                    res.clear();
                    closest = newSum;
                }
                if (target - newSum > target - closest) continue;
                // add all the As having the same val as the one at aIdx
                while (aIdx < a.size() && aVal == a.get(aIdx).get(1)) {
                    res.add(Arrays.asList( bId, a.get(aIdx).get(0)));
                    aIdx++;
                }
            }
        }

        return res;
    }

    private static int search(List<List<Integer>> pairs, int target) { // return the idx of the closest val, if not found return -1
        int left = 0, right = pairs.size() - 1;
        if (pairs.get(left).get(1) > target) {
            return -1;
        }
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (pairs.get(mid).get(1) >= target) {
                right = mid;
            } else if (pairs.get(mid).get(1) < target) {
                left = mid;
            }
        }

        if (pairs.get(right).get(1) > target ||
                pairs.get(left).get(1) == target ||
                pairs.get(left).get(1) == pairs.get(right).get(1)) {
            return left;
        }

        return right;
    }


}
