/**
 * Definition for undirected graph. class UndirectedGraphNode { int label;
 * List<UndirectedGraphNode> neighbors; UndirectedGraphNode(int x) { label = x;
 * neighbors = new ArrayList<UndirectedGraphNode>(); } };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

        if (node == null)
            return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> que = new LinkedList<>();
        que.add(node);
        map.put(node, new UndirectedGraphNode(node.label));

        while (!que.isEmpty()) {
            UndirectedGraphNode nodePtr = que.poll();

            for (UndirectedGraphNode neighbor : nodePtr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    que.add(neighbor);
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                }
                map.get(nodePtr).neighbors.add(neighbor);
            }
        }

        return map.get(node);
    }
}