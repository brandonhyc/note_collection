/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here

        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, 1);
                } else {
                    map.put(neighbor, map.get(neighbor) + 1);
                }
            }
        }

        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            result.add(node);

            for (DirectedGraphNode neighbor : node.neighbors) {
                int degree = map.get(neighbor);
                
                map.put(neighbor, degree - 1);

                if (degree - 1 == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return result;
    }
}