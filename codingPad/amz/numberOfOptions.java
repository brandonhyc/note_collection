package codingPad.amz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class numberOfOptions {

    class Solution {
        public int numberOfOptions(List<Integer> a, List<Integer> b, List<Integer> c, List<Integer> d, int limit) {

            // get all combs of a and b - ABs, then sort
            // get all combs of c and d - CDs, then sort

            // use two pointer to find number of pairs of ABs and CDs that the pair sum is no larger than target

            List<Integer> ABs = new ArrayList<>(), CDs = new ArrayList<>();
            for (Integer x : a) {
                for (Integer y : b) {
                    ABs.add(x + y);
                }
            }
            Collections.sort(ABs);

            for (Integer x : c) {
                for (Integer y : d) {
                    CDs.add(x + y);
                }
            }
            Collections.sort(CDs);

            int numRes = 0;
            int pl = 0,             // pointer to ABs from the first elm
                    pr = CDs.size() - 1; // pointer to CDs from the last elm

            while (pl < ABs.size() && pr >= 0) {
                int sum = ABs.get(pl) + CDs.get(pr);
                if (sum > limit) { // too larger, find a smaller comb
                    pr--;
                } else {
                    numRes += pr + 1;
                    pl++;
                }
            }


            return numRes;
        }

    }
}
