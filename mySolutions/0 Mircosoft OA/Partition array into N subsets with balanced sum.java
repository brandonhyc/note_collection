// "static void main" must be defined in a public class.
// https://leetcode.com/discuss/interview-question/430981/
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(partition(new int[] { 1, 2, 3, 4, 5, 6 }, 3).toArray()));
        System.out.println(Arrays.toString(partition(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 3).toArray()));
    }

    static private List<List<Integer>> partition(int[] arr, int k) {
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < k; i++)
            buckets.add(new ArrayList<>());
        int[] sum = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> sum[a] - sum[b]);
        for (int i = 0; i < k; i++)
            pq.offer(i);

        for (int i = arr.length - 1; i >= 0; i--) {
            int j = pq.poll();
            sum[j] += arr[i];
            pq.offer(j);
            buckets.get(j).add(arr[i]);
        }
        return buckets;
    }
}