package codingPad.amz;

import java.util.HashMap;
import java.util.Map;

public class numPairsDivisibleBy60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {

            Map<Integer, Integer> adders = new HashMap<>(); // key: a % 60,  value: count
            int total = 0; // res of pairs

            for (int i = 0; i < time.length; i++) {
                int b = time[i] % 60;
                int complCount = b != 0 ? adders.getOrDefault(60 - time[i] % 60, 0) : adders.getOrDefault(0, 0);
                total += complCount;

                adders.put(b, adders.getOrDefault(b, 0) + 1);
            }

            return total;
        }
    }
}
