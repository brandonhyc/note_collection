/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// if N nodes in the tree
// there will be at most N level which means N cols
// so in the res, there will be N list in it and 1 node in each list

// in the bfs, it will take 1 node enqueue for each level, so it takes N times to traversal each node
// in the pq, it will contains and compare N node, it takes N * logN to compare each col integer
// Time: O(N + N * logN)
// Space: O(N)

// if N nodes in well form balanced tree
// there will be logN level which means logN cols

// in the bfs, it takes at most N/2 nodes in queue for the last level, and it also takes N times to traverse each node
// in the pq, it will contains logN cols and it takes logN * log (logN) to compare each col integer
// Time: (N + logN * (logN))
// Space: O(logN + N/2) -> O(N)



class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair<>(root, 0));
        
        while (queue.size() != 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode curr = pair.getKey();
                int col = pair.getValue();
                if (curr.left != null) queue.offer(new Pair<>(curr.left, col - 1));
                if (curr.right != null) queue.offer(new Pair<>(curr.right, col + 1));
                map.putIfAbsent(col, new ArrayList<>());
                map.get(col).add(curr.val);
            }
        }
        
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for (Integer i : map.keySet()) minheap.offer(i);
        
        while (minheap.size() != 0) res.add(map.get(minheap.poll()));
        
        return res;
    }
}