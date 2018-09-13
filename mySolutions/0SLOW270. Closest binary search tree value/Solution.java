import java.util.ArrayList;

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here

        // btree inorder traversal

        if (root == null) {
            return -1;
        }

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode ptr = root;

        while (!stack.empty() || ptr != null) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            list.add(ptr.val);
            ptr = ptr.right;
        }

        int res = (int) Math.abs(target - list.get(0));

        for (Integer val : list) {
            if (Math.abs(target - val) < Math.abs(target - res)) {
                res = val;
            }
        }

        return res;
    }
}