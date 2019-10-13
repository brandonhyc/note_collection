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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sums = 0;
        
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        
        backtrack(root, results, list);
        
        
        for (List<Integer> result : results) {
            int sum = 0;
            for (int i = 0; i < result.size(); i++) {
                sum = sum * 10 + result.get(i);
            }
            
            // System.out.printf("result: %s, sum: %d\n", result.toString(), sum);
            sums = sums + sum;
        }
        return sums;
    }
    
    private void backtrack(TreeNode root, List<List<Integer>> results, List<Integer> list) {
        
        if (root.left == null && root.right == null) {
            results.add(new ArrayList<>(list));
            return;
        }
        
        if (root.left != null) {
            list.add(root.left.val);
            backtrack(root.left, results, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            backtrack(root.right, results, list);
            list.remove(list.size() - 1);
        }
        
        
    }
    
    
}