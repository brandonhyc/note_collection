public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int[] seq : seqs) { 
            // seq: [from -> to]
            for (int i = 0; i < seq.length; i++) {
                graph.putIfAbsent(seq[i], new ArrayList<Integer>());
                indegree.putIfAbsent(seq[i], 0);
                if (i > 0) {
                    graph.get(seq[i - 1]).add(seq[i]);
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
                }
            }
        }
        if (org.length > indegree.size()) {
            return false;
        }

        Queue<Integer> que = new LinkedList<>();
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                que.add(key);
            }
        }

        int index = 0;
        while (que.size() == 1) {
            int ptr = que.poll();
            if (index < org.length) {
                if (org[index] != ptr) {
                    return false;
                }                
            } else if (index > org.length) {
                return false;
            }
            index++;
            
            for (int neighbor : graph.get(ptr)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    que.add(neighbor);
                }
            }
        }
        return index == org.length;
    }
}