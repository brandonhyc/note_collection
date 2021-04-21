package codingPad.amz;

import java.util.List;

public class autoScale {
    public static int autoScale(List<Integer> averageUtils, int numInstances) {
        int currTime = 0;
        while (currTime < averageUtils.size()) {
            int utl = averageUtils.get(currTime);
            if (25 <= utl && utl <= 60) {
                currTime++;
            } else {
                if (utl < 25 && numInstances != 1) {
                    numInstances = (numInstances + 1) / 2;
                    currTime += 10;
                } else if (utl > 60 && numInstances * 2 <= (int)(2 * Math.pow(10, 8))) {
                    numInstances *= 2;
                    currTime += 10;
                } else {
                    currTime++;
                }
            }
        }

        return numInstances;
    }
}
