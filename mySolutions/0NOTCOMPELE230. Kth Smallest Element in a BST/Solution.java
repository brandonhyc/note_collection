/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */





    What if the BST is modified (insert/delete operations) often and 
    you need to find the kth smallest frequently? 
    How would you optimize the kthSmallest routine?

        /* SIMIPLE SOLUTION*/
public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        if (root == null || k < 1) {
            return -1;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (k == 1) {
                return curt.val;
            } else {
                k = k - 1;
            }
            curt = curt.right;
        }
        return -1;
    }
}