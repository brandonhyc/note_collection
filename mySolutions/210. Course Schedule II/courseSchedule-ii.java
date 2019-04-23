public class Solution {
    /*
     * @param numCourses: a total of n courses
     * 
     * @param prerequisites: a list of prerequisite pairs
     * 
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here

        // prerequisites: [0[target] 1[require]]
        // degree: target -> number of require
        // edges: ? -> ?
        if (numCourses == 0)
            return null;

        List[] edges = new ArrayList[numCourses];
        int[] degree = new int[numCourses];

        for (int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            degree[prerequisites[i][0]]++;
            edges[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        Queue<Integer> que = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                que.offer(i);
            }
        }
        while (!que.isEmpty()) {
            int done = que.poll();
            order.add(done);
            int n = edges[done].size();
            for (int i = 0; i < n; i++) {
                int next = (int) edges[done].get(i);
                degree[next]--;
                if (degree[next] == 0) {
                    que.offer(next);
                }
            }
        }

        if (order.size() == numCourses) {
            int[] array = new int[order.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = order.get(i);
            }
            return array;
        }

        return null;
    }}