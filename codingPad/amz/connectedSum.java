package codingPad.amz;

public class connectedSum {

    public int costEvaluation(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            weight[i] = 1;
        }

        int sum = 0;
        for (int[] pair : connections) {
            union(pair[0], pair[1], parent, weight);
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == i) {
                sum += (int) Math.ceil(Math.sqrt(weight[i]));
            }
        }
        return sum;
    }

    private int find(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    private void union(int i, int j, int[] parent, int[] weight) {
        i = find(i, parent);
        j = find(j, parent);

        if (weight[i] <= weight[j]) {
            weight[j] += weight[i];
            parent[i] = j;
        } else {
            weight[i] += weight[j];
            parent[j] = i;
        }
    }
}
