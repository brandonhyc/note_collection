/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here

        if (n == 0 || m == 0 || operators.length == 0) {
            return new ArrayList<>();
        }

        int result = 0;
        List<Integer> results = new ArrayList<Integer>();
        Set<List<Integer>> visited = new HashSet<>();
        // 1. read operator in operators
        // 2. bfs, if visited contains return origin result;
        
        for (int i = 0; i < operators.length; i++) {
            result = bfs(n, m, operators[i], visited, result);
            results.add(result);
        }
        return results;

    }


    private int bfs(int n, int m, Point operator, Set<List<Integer>> visited, int count) {
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        List<Integer> point = new ArrayList<>();
        point.add(operator.x);
        point.add(operator.y);

        System.out.print("Point: ");
        System.out.println(point);

        for (int i = 0; i < 4; i++) {
            int nx = operator.x + dx[i];
            int ny = operator.y + dy[i];

            List<Integer> nextPoint = new ArrayList<>();
            nextPoint.add(nx);
            nextPoint.add(ny);

            if (0 <= ny && ny < m &&
                0 <= nx && nx < n &&
                visited.contains(nextPoint)) {
                
                continue;
            }
                System.out.print("nextPoint: ");
                System.out.println(nextPoint);
         
            count++;
            break;
        }
        return count;
    }
}