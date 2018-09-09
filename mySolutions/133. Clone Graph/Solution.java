/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *          label = x; 
 *          neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null)
            return node;

        Set<UndirectedGraphNode> nodes = getNodes(node);

        // copy neighbors(edges)
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            map.put(n, new UndirectedGraphNode(n.label));            
        }

        for (UndirectedGraphNode n : nodes) {
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode copyNeighbor = map.get(neighbor);
                map.get(n).neighbors.add(copyNeighbor);
            }
        }

        return map.get(node);
    }

    private Set<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        que.offer(node);
        set.add(node);

        while(!que.isEmpty()) {
            UndirectedGraphNode head = que.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    que.offer(neighbor);
                }
            }
        }

        return set;
    }

}