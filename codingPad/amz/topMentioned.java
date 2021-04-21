package codingPad.amz;

import java.util.*;

public class topMentioned {
    public static List<String> topMentioned(int k, List<String> keywords, List<String> reviews) {

        Map<String, Integer> freq = new HashMap<>();
        PriorityQueue<String> minheap = new PriorityQueue<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String a, String b) {
                        int cp = Integer.compare(freq.get(a), freq.get(b));
                        if (cp == 0) {
                            return b.compareTo(a);
                        }

                        return cp;
                    }
                }
        );

        for (int i = 0; i < reviews.size(); i++) {
            reviews.set(i, reviews.get(i).toLowerCase());
        }

        for (String keyword : keywords) {
            for (String re : reviews) {
                if (re.indexOf(keyword) != -1) {
                    freq.put(keyword, freq.getOrDefault(keyword, 0) + 1);
                }
            }
        }

        // using minheap to find the top k
        for (String keyword : freq.keySet()) {
            minheap.offer(keyword);
            if (minheap.size() > k) {
                minheap.poll();
            }
        }
        List<String> res = new ArrayList<>();
        while (!minheap.isEmpty()) {
            res.add(minheap.poll());
        }
        Collections.reverse(res);

        return res;
    }
}
