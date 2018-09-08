public class Solution {

        /**
         * @param n     an integer
         * @param edges a list of undirected edges
         * @return true if it's a valid tree, or false
         */

        public boolean validTree(int n, int[][] edges) {  
            // edges: [
            //          [from, to],
            //          [1, 2],
            //          [2, 3]
            //        ]

            if (edges.length == 0 && n > 1 || n == 0) {
                return false;
            }
            
            if (n == 1) {
                return true;
            }

            Set[] neighbors = new Set[n];
            Set<Integer> all = new HashSet<>();

            for (int[] pos : edges) {
                if (neighbors[pos[0]] == null) {
                    neighbors[pos[0]] = new HashSet<Integer>(Arrays.asList(pos[1]));
                    all.add((int) pos[0]);

                } else {
                    neighbors[pos[0]].add(pos[1]);
                }
            }


            // for loop case BFS 
            Queue<Integer> que = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                Set<Integer> visited = new HashSet<>();

                que.offer(i);
                while(!que.isEmpty()) {
                    int num = que.poll();
                    System.out.print("" + visited);
                    System.out.print(" " + num + "\n");
                    if (!visited.add(num)) {
                        return false;
                    } 
                    if (neighbors[num] != null) {
                        for (Object x : neighbors[num]) {
                            que.offer((int) x);
                            all.add((int) x);
                        }
                    }

                }
            }

            if (all.size() != n) {
                return false;
            }

            return true;
        }
    }