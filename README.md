# 写在最前

生病了几个月, 停止了学校的课程, 也算荒废了半年. 回家后, 家里一切安好. 
于是收拾心情, 又回到美国, 想要做点什么. 如果1月份前找不到fulltime, 就宣布放弃正常计划. 
从零刷题也只是尝试. 至少努力过.

-9.1.2018记

最近这个星期都在刷题. 刷了一个星期, 平均每天4道题. 速度还勉强ok. 生活状态还是挺美滋滋的.
ICC那边最后一面的时候, 我说需要考虑一下简历修改的问题. 我还是不想做偷鸡摸狗的事情, 所以说需要考虑一下. 
于是HR那边就不考虑我了.
但是有消息称, 很多人通过不光彩的手段进入大公司. 在进入大公司后, 算法和数据结构其实不会用到.
我的信心有点动摇了. 不知道自己努力有没有用, 也不知道结果是怎么样.
然而, 我还是在刷题过程中学到不少. 也挺喜欢的. 

-9.9.2018记

这两天心里很不踏实. 联系上了Antra, 准备面试他们的前端. 心里面还是有点怂的. 所以就复习了一两天. 
题也没有刷, 今天重新开始进度吧.
明天就面试, 也不知道结果会不会好, 也不知道Batch满了没有. 跟我面试的将会是一个印度小哥. 
想想就觉得烦. 饭也没什么好吃的.. 自己一个人生活, 一个人煮饭. 只会水煮...

-9.17.2018记

# 时间复杂度 空间复杂度
## Set
集合 Set，是一组无重复的元素。

### HashSet
HashSet 以哈希表实现。插入的元素是无序的。add，remove 和 contains 都是常数时间复杂度 O(1)。

### TreeSet
TreeSet 以红黑树实现。插入的元素由树结构保持了顺序。add，remove 和 contains 都是对数时间复杂度 O(logn)。但是，它带来了查找 search，以及有序操作 first，last，headSet，tailSet 的高效。


## 哈希表 Hash Table
* (Keys) => hash function -> put in buckets 
* 时间复杂度 O(sizeOfKey ~~ 1)
* Collision: 1. (more common) open hashing: linkedList.add(new) / travels;  2. close hashing 
* Rehashing: 当 n(包括链内的元素个数) > 10% capacity, 进行扩容. 过程为遍历所有元素再hash计算.

## % 取余操作
* 负数取余 a % b = (a % b + b) % b


### 堆 Heap 
* 时间复杂度 add(): logn, poll(): logn, min/max: O(1)

## 双指针 Two Pointer

### 适用范围: 

1. 有序数组.
2. 原数组内交换.
3. 两数求和.


# 模板


## BTree
### Binary Tree Inorder Traversal
https://www.lintcode.com/problem/binary-tree-inorder-traversal/description

````java
public ArrayList<Integer> inorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    ArrayList<Integer> result = new ArrayList<Integer>();
    TreeNode curt = root;
    while (curt != null || !stack.empty()) {
        while (curt != null) {
            stack.add(curt);
            curt = curt.left;
        }
        curt = stack.pop();
        result.add(curt.val);
        curt = curt.right;
    }
    return result;
}
````

### Binary Tree Preorder Traversal
https://www.jiuzhang.com/solution/binary-tree-preorder-traversal/

````java
public List<Integer> preorderTraversal(TreeNode root) {
    // write your code here
    Stack<TreeNode> stack = new Stack<TreeNode>();
    List<Integer> res = new ArrayList<Integer>();

    if (root == null) {
        return res;
    }

    stack.push(root);
    while (!stack.empty()) {
        TreeNode node = stack.pop();
        res.add(node.val);
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }

    return res;
}
````

### Binary Tree Postorder Traversal
https://www.jiuzhang.com/solution/binary-tree-postorder-traversal/



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
### BFS优化 (Bidirectional BFS) 
https://www.jiuzhang.com/tutorial/algorithm/371


## Depth First Search (DFS)
多用于求组合的情况


### DFS 求组合
*易错点1:* 分不清 i 还是 startIndex
helper(nums, results, startIndex + 1, subset);
正确为helper(nums, results, i + 1, subset);
*易错点2:* 错误地直接返回list, 而不是复制结果后再写入
如果在递归出口直接调用list, 只会返回一个指针, 而该指针内的内容会被改写.
*易错点3:* 忘记Arrays.sort()

*优化1* 一般求和, 可以判断当前组合值的和, 如果已经超过预期值, 可以提早break


xxxxxxxxxxxx|Number | String
non-repeated| Permutation | 
repeated| permutation ii   | String permutation



````java
public class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();

        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        Arrays.sort(nums);

        helper(nums, results, 0, new ArrayList<>());

        return results;
    }

    private void helper(int[] nums, 
                        List results, 
                        int startIndex, 
                        List subset) {
        
        results.add(new ArrayList<>(subset));
        
        for (int i = startIndex; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && i > startIndex){
                continue; // 用于去重
            }
            subset.add(nums[i]);
            helper(nums, results, i + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }
}
````
### 组合去重
例如[1,2',2''], 保证 2 没有被重复提取. 
首先, 通过Arrays.sort()保证提取是紧挨着的. 其次, 就是在循环过程中加判断 
```java
Arrays.sort(nums);

if (i != 0 && nums[i] == nums[i - 1] && i > startIndex){
    continue; // 用于去重
}

```

### Memorized DFS 求组合
```java
    private List<String> helper(
        String s, Set<String> dict, Map<String, ArrayList<String>> map) {

        ArrayList<String> results = new ArrayList<String>();

        if (map.containsKey(s)) {
            return map.get(s);
        }
        if (dict.contains(s)) {
            results.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String word = s.substring(0, i);
            
            if (!dict.contains(word)) {
                continue;
            }
            String suffix = s.substring(i);
            List<String> segmentations = helper(suffix, dict, map);
            
            for (String seg: segmentations) {
                String result = word + " " + seg;
                results.add(result);
            }
        }
        map.put(s, results);
        return results;
    }
```

### DFS Permutation
```java
public class Solution {
    /*
     * @param nums: A list of integers.
     * 
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums.length == 0) {
            results.add(new ArrayList<>());
            return results;
        }

        dfs(nums, new boolean[nums.length], new ArrayList<>(), results);
        return results;

    }
    private void dfs(int[] nums, 
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {        

        if (nums.length == permutation.size()) {
            results.add(new ArrayList<>(permutation));
            return;
            //exit
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
        return;
    }
}
```

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