/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            (x, y) -> Math.abs(target - y) > Math.abs(target - x) ? 1 : Math.abs(target - y) == Math.abs(target - x) ? 0 : -1);
        
        Stack<TreeNode> stack = new Stack<>();
        
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            saveClosestKValues(root, target, k, maxHeap);
            
            root = root.right;
        }
        
        List<Integer> results = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            results.add(maxHeap.poll());
        }
        
        return results;
        
    }
        
    private void saveClosestKValues(TreeNode root, double target, int k, PriorityQueue<Integer> maxHeap) {
            maxHeap.offer(root.val);
        if (maxHeap.size() > k) {
            maxHeap.poll();
        }
    }
}