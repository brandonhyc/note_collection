/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null || k == 0) {
            return result;
        }

        TreeNode curt = root;
        while (curt != null || !stack.isEmpty()) {
            while(curt != null) {
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            list.add(curt.val);
            curt = curt.right;
        }

        int smallestIndex = 0;
        double temp = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            if (Math.abs(list.get(i) - target) < temp) {
                smallestIndex = i;
                temp = Math.abs(list.get(i) - target);
            }
        }

        int left = smallestIndex;
        int right = smallestIndex + 1;

        while (left >= 0 && right < list.size()) {
            if (k == 0) break;
            System.out.printf("left: %d, right: %d, list:%s\n", left, right, list.toString());
            if (Math.abs(list.get(left) - target) < Math.abs(list.get(right) - target)) {
                result.add(list.get(left));
                left--;
            } else {
                result.add(list.get(right));
                right++;
            }
            k--;
        }

        while (k > 0 && left >= 0) {
            result.add(list.get(left));
            left--;
            k--;
        }
        while (k > 0 && right < list.size()) {
            result.add(list.get(right));
            right++;
            k--;
        }

        return result;
    }
}