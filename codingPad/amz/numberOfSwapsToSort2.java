package codingPad.amz;

import java.util.*;

public class numberOfSwapsToSort2 {

    public static int numberOfSwapsToSort(List<Integer> nums) {

        // pre-compute the correct order
        Map<Integer, Integer> sortedIdxMap = new HashMap<>(); // key: num, value: sorted idx of num
        List<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);
        for (int i = 0; i < nums.size(); i++) {
            sortedIdxMap.put(sortedNums.get(i), i);
        }

        List<Integer> currIdxs = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            currIdxs.add(sortedIdxMap.get(nums.get(i)));
        }

        // find all circles from left to right
        boolean[] visited = new boolean[currIdxs.size()];
        int reqSwap = 0;
        for (int i = 0; i < currIdxs.size(); i++) {
            if (i == currIdxs.get(i) || visited[i]) { // already in correct position / processed
                visited[i] = true;
                continue;
            }

            // not in correct place yet, then find the whole cycle
            int j = currIdxs.get(i), cycleSize = 1;
            visited[i] = true;

            while (!visited[j]) {
                visited[j] = true;
                j = currIdxs.get(j);
                cycleSize++;
            }
            reqSwap += cycleSize - 1;
        }

        return reqSwap;
    }
}
