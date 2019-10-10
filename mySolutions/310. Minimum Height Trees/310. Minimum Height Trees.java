class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }
        
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
                
                if (!map.containsKey(edge[0])) {
                    map.put(edge[0], new HashSet());
                }   
                Set<Integer> set = map.get(edge[0]);
                set.add(edge[1]);
            
                if (!map.containsKey(edge[1])) {
                    map.put(edge[1], new HashSet());
                }
                set = map.get(edge[1]);
                set.add(edge[0]);
        }
        
        Queue<Integer> leaves = new LinkedList<>();
        
        for (int vertex : map.keySet()) {
            if (map.get(vertex).size() == 1) {
                leaves.add(vertex);
            }
        }
        
        while (n > 2) {
            // System.out.printf("leaves: %s, map: %s\n", leaves.toString(), Arrays.toString(map.entrySet().toArray()));
            int size = leaves.size();
            n -= size;

            for (int i = 0; i < size; i++) {
                int leaf = leaves.poll();
                int adj = map.get(leaf).iterator().next();
                Set<Integer> neighbors = map.get(adj);
                neighbors.remove(leaf);
                if (neighbors.size() == 1) {
                    leaves.add(adj);
                }
            }
            
        }
        
        return (List) leaves;
    }
}  
        