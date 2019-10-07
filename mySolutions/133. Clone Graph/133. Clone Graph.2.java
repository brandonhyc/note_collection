/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>(); 
        
        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node origin = queue.poll();
                Node clone = map.get(origin);

                for (Node orginNeighbor: origin.neighbors) {
                    if (!map.containsKey(orginNeighbor)) {
                        Node cloneNeighbor = new Node(orginNeighbor.val, new ArrayList<>());
                        map.put(orginNeighbor, cloneNeighbor);
                        clone.neighbors.add(cloneNeighbor);
                        queue.offer(orginNeighbor);
                    } else {
                        clone.neighbors.add(map.get(orginNeighbor));
                    }
                }
                
            }
            
        }
        return map.get(node);
        
        
    }
}