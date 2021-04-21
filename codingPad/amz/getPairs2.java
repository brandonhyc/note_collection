package codingPad.amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class getPairs2 {

    class Solution {
        public  List<List<Integer>> getPairs(List<List<Integer>> a, List<List<Integer>> b, int target) {
            Collections.sort(a, (A, B) -> Integer.compare(A.get(1), B.get(1)));
            Collections.sort(b, (A, B) -> Integer.compare(A.get(1), B.get(1)));

            List<List<Integer>> res = new ArrayList<>();
            Integer closest = null;
            int pA = 0, pB = b.size() - 1;
            while (pA < a.size() && pB >= 0) {
                int sum = a.get(pA).get(1) + b.get(pB).get(1);
                if (sum > target) {
                    pB--;
                    continue;
                }
                if (sum < target && closest != null && target - closest < target - sum) {
                    pA++;
                    continue;
                }
                if (closest == null || target - closest > target - sum) { // found a closer pair
                    closest = sum;
                    res.clear();
                }

                int nPB = pB;
                while (nPB >= 0 && b.get(nPB).get(1) == b.get(pB).get(1)) {
                    res.add(Arrays.asList(a.get(pA).get(0), b.get(nPB).get(0)));
                    nPB--;
                }

                pA++;
            }
            Collections.sort(res, (A, B) -> {
                int cp = Integer.compare(A.get(0), B.get(0));
                if (cp != 0) return cp;
                return Integer.compare(A.get(1), B.get(1));
            });

            return res;
        }

    }
}
