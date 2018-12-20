/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param s: Undirected graph node
     * @param t: Undirected graph nodes
     * @return: an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here

        if (graph == null || s == null || t == null) {
            return -1;
        }

        int maxSteps = 6;
        int currentSteps = -1;
        Set<UndirectedGraphNode> visited = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(s);

        while (!queue.isEmpty()) {            
            currentSteps++;

            // if (currentSteps > maxSteps) {
            //     return -1;
            // }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);
                if (node == t) {
                    return currentSteps;    
                }

                for (UndirectedGraphNode neighbor: node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return -1;
    }
}