package codingPad.amz;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class fiveStarReviews {
    public static int fiveStarReviews(List<List<Integer>> ratings, int threshold) {
        // put all ratings in maxheap, compared in such way that
        //     (review count + 1 ) / (total review count + 1) - (review count) / (total review count) in desc order
        // pop an entry from maxheap each time until the current rating is above threshold
        //    recalulate current threshold, push the entry back in max heap after add the new 5-star
        //    requiring review count ++

        PriorityQueue<List<Integer>> maxheap = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b) {
                double numA = a.get(0), denA = a.get(1), numB = b.get(0), denB = b.get(1);
                double dffA = (numA + 1) / (denA + 1) - (numA / denA);
                double dffB = (numB + 1) / (denB + 1) - (numB / denB);
                return Double.compare(dffB, dffA);
            }
        });
        double currRating = 0;
        int addCount = 0;

        for (int i = 0; i < ratings.size(); i++) {
            maxheap.add(ratings.get(i));
            currRating += ratings.get(i).get(0) / (double) ratings.get(i).get(1);
        }


        while (currRating / (double) ratings.size() < threshold / 100.0) {
            List<Integer> pair = maxheap.poll();

            // recal
            currRating -= pair.get(0) / (double)pair.get(1);
            currRating += (pair.get(0) + 1) / (double) (pair.get(1) + 1);

            pair.set(0, pair.get(0) + 1);
            pair.set(1, pair.get(1) + 1);
            maxheap.offer(pair);
            addCount++;
        }

        return addCount;
    }
}
