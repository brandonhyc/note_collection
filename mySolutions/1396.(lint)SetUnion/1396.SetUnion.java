public class Solution {
    /**
     * @param sets: Initial set list
     * @return: The final number of sets
     */

    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int setUnion(int[][] sets) {
        // Write your code here

        if (sets == null || sets.length == 0 || sets[0].length == 0) {
            return 0;
        }

        for (int i = 0; i < sets.length; i++) {
            int father = sets[i][0];
            for (int j = 0; j < sets[i].length; j++) {
                if (map.containsKey(sets[i][j])) {
                    union(father, map.get(sets[i][j]));
                } else {
                    map.put(sets[i][j], father);
                }
            }
        }

        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < sets.length; i++) {
            for (int j = 0; j < sets[i].length; j++) {
                int father = find(sets[i][j]);
                if (!set.contains(father)) {
                    set.add(father);
                }
            }
        }
        return set.size();
    }

    private int find(int x) {
        if (map.get(x) == x) {
            return x;
        }

        map.put(x, find(map.get(x)));
        return map.get(x);
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            map.put(rootA, rootB);
        }
        return;
    }
}