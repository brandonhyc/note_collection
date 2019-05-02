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
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k == 0) {
            return -1;
        }
        
        List<Integer> result = new ArrayList<>();
        
        inorder(root, result);
        
        return result.get(k - 1);
    }
    
    private void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}