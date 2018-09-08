# 写在最前

生病了几个月, 停止了学校的课程, 也算荒废了半年. 回家后, 家里一切安好. 
于是收拾心情, 又回到美国, 想要做点什么. 如果1月份前找不到fulltime, 就宣布放弃正常计划. 
从零刷题也只是尝试. 至少努力过.

-9.1.2018记


## 双指针 Two Pointer

### 适用范围: 

1. 有序数组.
2. 原数组内交换.
3. 两数求和.


# 模板

## Topological Sorting 拓扑排序 

https://www.jiuzhang.com/solutions/topological-sorting/

````java
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> map = new HashMap();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1); 
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                q.offer(node);
                result.add(node);
            }
        }
        while (!q.isEmpty()) {
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode n : node.neighbors) {
                map.put(n, map.get(n) - 1);
                if (map.get(n) == 0) {
                    result.add(n);
                    q.offer(n);
                }
            }
        }
        return result;
    }
}
````

## Breath First Search (BFS)

https://www.jiuzhang.com/solution/number-of-islands/

````java

public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        boolean[][] v = new boolean[grid.length][grid[0].length];

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!v[i][j] && grid[i][j]) {
                    bfs(grid, v, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(boolean[][] grid, boolean[][] v, int i, int j) {

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.offer(i);
        qy.offer(j);
        v[i][j] = true;

        while (!qx.isEmpty()) {

            int cx = qx.poll();
            int cy = qy.poll();

            int[] dx = { 1, 0, -1, 0 };
            int[] dy = { 0, 1, 0, -1 };
            for (int x = 0; n < 4; x++) {
                int nx = cx + dx[n];
                int ny = cy + dy[n];

                if (nx >= 0 && nx <= grid.length - 1 && ny >= 0 && ny <= grid[0].length - 1) {

                    if (!v[nx][ny] && grid[nx][ny]) {
                        qx.offer(nx);
                        qy.offer(ny);
                        v[nx][ny] = true;
                    }
                }
            }
        }
    }
}


````



## Quicksort

Quick select:
http://www.jiuzhang.com/solutions/kth-largest-element/

Quick sort:
http://www.jiuzhang.com/solutions/quick-sort/

````java
public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int start, int end) {
        if (start >= end) return;
        
        int left = start, right = end;
        int pivot = A[(start + end) / 2];
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left]; A[left] = A[right]; A[right] = temp;
                left++; right--;
            }
        }
        
        quickSort(A, start, right);
        quickSort(A, left, end);
    }
}
````