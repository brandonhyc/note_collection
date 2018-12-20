public class ConnectingGraph { 

    private int[] parent;

    private int find(int x) {
        if (parent[x] == x) {
            return x; 
        }

        parent[x] = find(parent[x])
        return parent[x];
    }

    public ConnectingGraph(int n) {
        // initialize your data structure here.
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rooA] = rootB;
        }
    }
        
    public boolean query(int a, int b) {
        // Write your code here

        int rootA = find(a);
        int rootB = find(b);

        return rootA == rootB;
    }
}