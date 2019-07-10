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

        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> valMapNode = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        valMapNode.put(newNode.val, newNode);

        Queue<Node> que = new LinkedList<>();
        que.offer(node);

        while (!que.isEmpty()) {
            Node original = que.poll();
            Node clone = valMapNode.get(original.val);

            for (Node neighbor : original.neighbors) {
                if (!valMapNode.containsKey(neighbor.val)) {
                    Node cloneNeighbor = new Node(neighbor.val, new ArrayList<>());
                    valMapNode.put(cloneNeighbor.val, cloneNeighbor);
                    que.offer(neighbor);
                }
                Node temp = valMapNode.get(neighbor.val);
                clone.neighbors.add(temp);
            }

        }
        return newNode;
    }
}