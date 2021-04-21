package codingPad.amz;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Turnstile {

    class Solution {
        public List<Integer> getTimes(int numWorker, List<Integer> arrTime, List<Integer> direction) {
            Queue<Integer> unloading = new LinkedList<>(); // to store all pending unloading workers
            Queue<Integer> loading = new LinkedList<>();
            int[] workingTime = new int[numWorker];

            int currTime = 0;
            int lastUsed = 1;

            int arrIdx = 0;

            while (arrIdx < arrTime.size() || !unloading.isEmpty() || !loading.isEmpty()) { // any one has not arrive or any one has not finished
                // for each second
                while (arrIdx < arrTime.size() && arrTime.get(arrIdx) <= currTime) {
                    if (direction.get(arrIdx) == 0) {
                        loading.add(arrIdx);
                    } else {
                        unloading.add(arrIdx);
                    }
                    arrIdx++;
                }

                if (!loading.isEmpty() && (unloading.isEmpty() || lastUsed == 0)) {
                    workingTime[loading.poll()] = currTime;
                    lastUsed = 0;
                } else if (!unloading.isEmpty() && (loading.isEmpty() || lastUsed == 1)) {
                    workingTime[unloading.poll()] = currTime;
                    lastUsed = 1;
                }
                currTime++;
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < workingTime.length; i++) {
                res.add(workingTime[i]);
            }

            return res;
        }

    }


}
