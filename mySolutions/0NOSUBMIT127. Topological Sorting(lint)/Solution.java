/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { 
 *          label = x; 
 *          neighbors = new ArrayList<DirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        
        if (graph == null || graph.length == 0) return null;

        Map<DirectedGraphNode, Integer> map = new HashMap<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<>();

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, 1);
                } else {
                    map.put(neighbor, map.get(neighbor) + 1);                    
                }
            }
        }

        Queue<DirectedGraphNode> que = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                que.offer(node);
            }
        }
        while (!que.isEmpty()) {
            res.add(que.poll());
            
            for (DirectedGraphNode neighbor : que.neighbors) {
                int degree = map.get(neighbor) - 1;
                map.put(neighbor, degree);
                if (degree == 0) {
                    que.offer(neighbor);
                }
            }
        }

        return res;
        
    }
}