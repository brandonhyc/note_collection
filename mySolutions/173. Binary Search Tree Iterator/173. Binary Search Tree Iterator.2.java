/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode ptr;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        ptr = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        while (ptr != null) {
            stack.push(ptr);
            ptr = ptr.left;
        }
        
        ptr = stack.pop();
        int temp = ptr.val;
        ptr = ptr.right;
        return temp;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || ptr != null;
    }

    
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */