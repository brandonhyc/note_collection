// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] lengths = new int[]{5,4,4,2,2,8};
        System.out.println(Arrays.toString(cut(lengths).toArray()));
    }
    
    static private List<Integer> cut(int[] lengths) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (int i = 0; i < lengths.length; i++) {
            minheap.offer(lengths[i]);
        }
        List<Integer> logs = new ArrayList<>();
        while (minheap.size() != 0) {
            int size = minheap.size();
            // System.out.printf("pq: %s\n", Arrays.toString(minheap.toArray()));
            logs.add(size);
            int min = minheap.peek();
            Queue<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int cutLen = minheap.poll() - min;
                if (cutLen != 0) tmp.add(cutLen);
            }
            while (tmp.size() != 0) minheap.offer(tmp.poll());
        }
        return logs;
    }
}