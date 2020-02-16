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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root, prev = null, d1 = null, d2 = null;
        
        while (st.size() != 0 || curr != null) {
            while (curr != null) {
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            if (prev != null && prev.val > curr.val) {
                if (d1 == null) {
                    d1 = prev;
                    d2 = curr;
                } else {
                    d2 = curr;
                }
            }
            prev = curr;
            curr = curr.right;
        }
        
        if (d1 != null && d2 != null) {
            int temp = d1.val;
            d1.val = d2.val;
            d2.val = temp;
        }
    }
}