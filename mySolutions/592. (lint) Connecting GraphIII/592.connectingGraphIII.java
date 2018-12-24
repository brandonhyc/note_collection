public class ConnectingGraph { 

    private int[] father = null;
    private int[] size = null;

    private int find(int x) {
        int root, k;
        root = x;
        while (father[root] != root) {
            root = father[root];
        }

        int temp;
        while (x != root) {
            temp = father[x];
            father[x] = root;
            x = temp;
        }
    }

    public ConnectingGraph2(int n) {
        // initialize your data structure here.
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public void connect(int a, int b) {
        // Write your code here
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootA] = rootB;
            size[rootB] += size[rootA];
            find(a);
        }
    }
        
    public int query(int a) {
        // Write your code here
        int rootA = find(a);
        return size[rootA];
    }
}