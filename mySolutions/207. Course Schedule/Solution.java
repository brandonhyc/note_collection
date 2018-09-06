public class Solution {
    /*
     * @param numCourses: a total of n courses
     * 
     * @param prerequisites: a list of prerequisite pairs
     * 
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here

        List[] edges = new ArrayList<Integer>[numCourses];
        int[] degree = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            // prereq: [item] : 0[targer] , 1[require]
            // edges:  [ require ->{ 1, 2 ...}]
            // degree: no of (target -> ?) 
           edges[prerequisites[i][1]].add(prerequisites[i][0]);
           degree[prerequisites[i][0]]++;
        }

        Queue<Integer> que = new LinkedList<Integer>();
        int count = 0;
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) que.offer(i);
        }

        while (!que.isEmpty()) {
            int done = que.poll();
            count++;

            for (int i = 0; i < edges[done].length; i++) {
                int next = edges[done].get(i);
                degree[next]--;
                if (degree[next] == 0) {
                    que.add(next);
                }
            }

        } 

        return count == numCourses;
    }
}