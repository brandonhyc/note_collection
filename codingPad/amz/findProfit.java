package codingPad.amz;

import java.util.List;
import java.util.PriorityQueue;

public class findProfit {
    public static int findProfit(List<Integer> inventory, int orders) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((x, y) -> Integer.compare(y,x));

        for (int i = 0; i < inventory.size(); i++) {
            maxheap.offer(inventory.get(i));
        }

        int totalVal = 0;
        while (orders > 0) {
            // current max val order val
            int orderVal = maxheap.poll();
            int nextVal = maxheap.isEmpty() ? Integer.MIN_VALUE : maxheap.peek();

            while (orderVal >= nextVal && orders > 0) {
                totalVal = totalVal + orderVal;
                orders--;
                orderVal--;
            }

            maxheap.offer(orderVal);
        }
        return totalVal;
    }
}
