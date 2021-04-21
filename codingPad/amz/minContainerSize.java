package codingPad.amz;

import java.util.List;

class minContainerSize {
    public static int minContainerSize(List<Integer> boxSizes, int days) {
        return searchMinSize(boxSizes, 0, days);
    }

    // [3:[10, 2, 20], 2:[5, 15], 1:[10, 1]], d = 3

    private static int searchMinSize(List<Integer> boxSizes, int start, int days) {
        if (days == 0 && start == boxSizes.size()) {
            return 0;
        }
        if (days == 0) {
            return -1;
        }

        int maxSize = 0;
        int minTotal = Integer.MAX_VALUE;
        for (int i = start; i < boxSizes.size(); i++) {
            maxSize = Math.max(maxSize, boxSizes.get(i));
            int minTotalOfRest = searchMinSize(boxSizes, i + 1, days - 1);

            if (minTotalOfRest != -1 &&
                    (minTotal == Integer.MAX_VALUE || minTotalOfRest + maxSize < minTotal)) {
                minTotal = minTotalOfRest + maxSize;
            }
        }

        return minTotal != Integer.MAX_VALUE ? minTotal : -1;
    }
}