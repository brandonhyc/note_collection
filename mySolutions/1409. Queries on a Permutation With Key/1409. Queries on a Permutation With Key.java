class Solution {
    public int[] processQueries(int[] queries, int m) {
        // 3,1,2,1
        // 1,2,3,4,5
        
        // 3 at 2, 3,1,2,4,5
        // 1 at 1, 1,3,2,4,5
        // 2 at 2, 2,1,3,4,5
        // 1 at 1, 1,2,3,4,5
        
        
        int[] res = new int[queries.length];
        
        LinkedList<Integer> arr = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            arr.add(i);
        } 
        for (int i = 0; i < queries.length; i++) {
            int in = arr.indexOf(queries[i]);
            arr.remove(in);
            arr.addFirst(queries[i]);
            res[i] = in;
        }
        
        return res;
        
    }
}