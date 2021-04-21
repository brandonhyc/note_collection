package codingPad.amz;

import java.util.*;

class chooseAFlask {
    public static int chooseAFlask(int numOrders, List<Integer> requirements, int flaskTypes, List<List<Integer>> markings) {

        Map<Integer, List<Integer>> markingByType = new HashMap<>();
        for (List<Integer> standard : markings) {
            markingByType.putIfAbsent(standard.get(0), new ArrayList<>());
            markingByType.get(standard.get(0)).add(standard.get(1));
        }
        for (Integer key : markingByType.keySet()) {
            Collections.sort(markingByType.get(key));
        }
        int min = Integer.MAX_VALUE, resType = -1;

        for (int i = 0; i < flaskTypes; i++) {
            int totalWaste = 0;
            boolean failed = false;
            for (int j = 0; j < requirements.size(); j++) {
                int flaskMark = search(markingByType.get(i), requirements.get(j));
                if (flaskMark == -1) {
                    failed = true;
                    break;
                }
                totalWaste += flaskMark - requirements.get(j);
            }

            if (!failed && totalWaste < min) {
                resType = i;
                min = totalWaste;
            }
        }

        return resType;
    }

    public static int search(List<Integer> markings, int target) { // search the smallest mark larger or equal to the target
        int l = 0, r = markings.size() - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (markings.get(m) == target) {
                return markings.get(m);
            } else if (markings.get(m) > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return markings.get(l) < target ? -1 : markings.get(l);
    }


}