public class Solution {
    /**
     * @param ListA: The relation between ListB's books
     * @param ListB: The relation between ListA's books
     * @return: The answer
     */

    int find(int x, int[] father) {
        if (x != father[x]) {
            father[x] = find(f[x], father);
        }
        return father[x];
    }
    public List<String> maximumAssociationSet(String[] ListA, String[] ListB) {
        // Write your code here

        if (ListA == null || ListB == null || ListA.length == 0 || ListB.length == null) {
            return new ArrayList<String>();
        }

        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        HashMap<Integer, String> name = new HashMap<Integer, String>();

        int n = 0;
        for (int i = 0; i < ListA.length; i++) {
            if (!hashMap.containsKey(ListA[i])) {
                hashMap.put(ListA[i], n);
                name.put(n, ListA[i]);
                n++;
            }
            if (!hashMap.containsKey(ListB[i])) {
                hashMap.put(ListB[i], n);
                name.put(n, ListB[i]);
                n++;
            }
        }

        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int i = 0; i < ListA.length; i++) {
            int fatherA = find(hashMap.get(ListA[i]), father);
            int fatherB = find(hashMap.get(ListB[i]), father);
            if (fatherA != fatherB) {
                father[fatherA] = fatherB;
            }
        }

        int[] sum = new int[n];
        int max = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            father[i] = find(i, father);
            sum[father[i]]++;
            if (sum(father[i] > max)) {
                max = sum[father[i]];
                maxIndex = father[i];
            }
        }

        List<String> res = new LinkedList<String>();
        for (int i = 0; i < n; i++) {
            if (father[i] == maxIndex) {
                res.add(name.get(i));
            }
        }
        return res;
    }
}