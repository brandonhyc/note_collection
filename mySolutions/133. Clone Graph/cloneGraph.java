/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode graphNode) {
        // write your code here

        if (graphNode == null) {
            return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>(); 
        Set<UndirectedGraphNode> nodes = getNodes(graphNode);

        for (UndirectedGraphNode node : nodes) {
            map.put(node, new UndirectedGraphNode(node.label));
        }

        for (UndirectedGraphNode node : nodes) {
            UndirectedGraphNode copyNode = map.get(node);
            
            for (UndirectedGraphNode neighbor : node.neighbors) {
                UndirectedGraphNode copyNeighbor = map.get(neighbor);
                copyNode.neighbors.add(copyNeighbor);
            }
        }

        return map.get(graphNode);
    }

    private Set<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            set.add(head);
            
            for (UndirectedGraphNode neighbor : head.neighbor) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return set;
    }
}