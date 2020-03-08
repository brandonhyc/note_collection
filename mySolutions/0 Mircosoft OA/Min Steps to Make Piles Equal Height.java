// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println(minEqualizeHeights2(new int[]{1,2,5}));
        System.out.println(minEqualizeHeights2(new int[]{4,5,5,4,2}));
    }
    static private int minEqualizeHeights2(int[] hi) {
        
        Integer[] heights = new Integer[hi.length];
        for (int i = 0; i < hi.length; i++) heights[i] = hi[i];
        Arrays.sort(heights, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        // Collections.reverse(Arrays.asList(heights));
        System.out.printf("%s\n", Arrays.toString(heights));
        int same = 0;
        int steps = 0;        
        int i = 0;
        int end = heights.length - 1; // !! if it equals the last number, they are all same, so no need to check the last one
        
        while (i < end) {
            int curHi = heights[i];
            int j = i;
            for (; j < end && heights[j] == curHi; j++) same += 1;
            steps += same;
            i = j;
        }
        
        return steps;
    }
    
    // my own
    static private int minEqualizeHeights(int[] heights) {
        PriorityQueue<Integer> maxHi = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < heights.length; i++) maxHi.offer(heights[i]);
        int steps = 0;
        int same = 0;
        while (maxHi.size() != 0) {
            int mh = maxHi.peek(); // largest
            System.out.printf("before heights: %s\n", Arrays.toString(maxHi.toArray()));
            while (maxHi.size() != 0 && mh == maxHi.peek()) {
                maxHi.poll();
                same += 1;
            }
            if (maxHi.size() != 0) {
                maxHi.offer(maxHi.peek());
                steps += same;
                same -= 1;
            }
            
            System.out.printf("same: %d, steps: %d, heights: %s\n", same, steps, Arrays.toString(maxHi.toArray()));
        }
        
        return steps;
    }
    
}