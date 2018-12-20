/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */


public class Solution {
    /*
     * @param graph: a list of Undirected graph node
     * @param values: a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node: an Undirected graph node
     * @param target: An integer
     * @return: a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode startNode,
                                          int target) {
        // write your code here

        if (graph == null || graph.size() == 0) {
            return null;
        }
        if (values == null || values.size() == 0) {
            return null;
        }
        if (startNode == null) {
            return null;
        }

        Set<UndirectedGraphNode> visited = new HashSet<>();

        int distance = -1;
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(startNode);
        while (!queue.isEmpty()) {

            distance++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode node = queue.poll();
                
                if (visited.contains(node)) {
                    continue;
                }
                visited.add(node);

                if (values.get(node) == target) {
                    return node;
                }

                for (UndirectedGraphNode neighbor : node.neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return null;
    }
}