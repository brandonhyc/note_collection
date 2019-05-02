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

        TreeNode cur = root;
        
        Stack<TreeNode> stack = new Stack<>();
        while (result.size() < k) {
            
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            
            cur = stack.pop();
            result.add(cur.val);
            
            cur = cur.right;
        }
        
        return result.get(k - 1);
        
    }
}