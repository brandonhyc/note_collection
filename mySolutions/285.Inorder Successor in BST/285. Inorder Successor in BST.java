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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        // bst traverse and check if p exists in root;

        TreeNode prev = null;
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.val == p.val) {
                break;
            }

            if (cur.val < p.val) {
                prev = cur;
                cur = cur.left;
            }
            else {
                cur = cur.right;
            }
            
        }

        // not exist
        if (cur != null) {
            return null;
        }

        if (cur.right == null) {
            return prev;
        }

        cur = cur.right;
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur;

    }
}