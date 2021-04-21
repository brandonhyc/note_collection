package codingPad.amz;

import java.util.PriorityQueue;

public class fulfillment {

    class Solution {


        public int fulfillment(int[] parts) {
            PriorityQueue<Integer> minheap = new PriorityQueue<>();
            for (int i = 0; i < parts.length; i++) {
                minheap.offer(parts[i]);
            }

            int totalTime = 0;
            while (minheap.size() > 1) {
                int it1 = minheap.poll();
                int it2 = minheap.poll();
                int sum = it1 + it2;
                totalTime += sum;

                minheap.offer(sum);
            }

            return totalTime;
        }

    }
}
