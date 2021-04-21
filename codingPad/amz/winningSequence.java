package codingPad.amz;

import java.util.LinkedList;
import java.util.List;

public class winningSequence {

    public static List<Integer> winningSequence(int num, int lowerEnd, int upperEnd) {
        LinkedList<Integer> res = new LinkedList<>();
        if (num < 3 || upperEnd - lowerEnd < 1) {
            res.add(-1);
            return res;
        }

        res.add(upperEnd - 1);
        res.add(upperEnd);

        for (int i = 2; i < num; i++) {
            res.add(upperEnd - i + 1);
        }

        // [9 10 9 8 7]
        // [8 9 10 9 8] 7]

        while (res.getLast() < lowerEnd) {
            res.removeLast();
            res.addFirst(res.getFirst() - 1);
            if (res.getFirst() < lowerEnd) {
                res.clear();
                res.add(-1);
                return res;
            }
        }

        return res;
    }


}
