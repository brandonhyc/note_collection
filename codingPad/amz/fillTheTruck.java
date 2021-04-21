package codingPad.amz;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class fillTheTruck {
    class Solution {
        public int fillTheTruck(int num, List<Integer> boxes,
                                       int unitSize, List<Integer> unitsPerBox,
                                       int truckSize) {

            int[][] boxTypes = new int[boxes.size()][2]; // [count, units]
            for (int i = 0; i < boxes.size(); i++) {
                boxTypes[i] = new int[]{boxes.get(i), unitsPerBox.get(i)};
            }
            Arrays.sort(boxTypes, new Comparator<int[]>() {
                @Override
                public int compare(int[] boxA, int[] boxB) {
                    return Integer.compare(boxB[1], boxA[1]);
                }
            });

            int currSize = 0, currUnit = 0;
            int typeIdx = 0;
            while (typeIdx < boxTypes.length) {
                // try to add the current type of box as many as possible
                int maxCount = boxTypes[typeIdx][0];
                while (maxCount > 0 && truckSize < currSize + maxCount) {
                    maxCount--;
                }
                if (maxCount != 0) {
                    currSize += maxCount;
                    currUnit += maxCount * boxTypes[typeIdx][1];
                }

                typeIdx++;
            }

            return currUnit;

        }
    }
}
