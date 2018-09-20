/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } } 
 * Example of iterate a tree:
 *  
 * BSTIterator iterator = new BSTIterator(root); 
 * while (iterator.hasNext()) { 
 *      TreeNode node = iterator.next(); 
 *      do something for node }
 */

public class BSTIterator {
    /*
     * @param root: The root of binary tree.
     */
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode node;
    
    public BSTIterator(TreeNode root) {
        // do intialization if necessary
        node = root;
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        // write your code here
        return !stack.isEmpty() || node != null;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        // write your code here
        TreeNode temp = null;
        if (!stack.isEmpty() || node != null) {
            temp = null;
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            temp = node;
            node = node.right;

        }

        return temp;

    }
}