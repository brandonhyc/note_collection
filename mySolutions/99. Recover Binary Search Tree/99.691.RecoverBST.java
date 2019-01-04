/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the given tree
     * @return: the tree after swapping
     */
    private TreeNode lastNode = new TreeNode(Integer.MIN_VALUE);
    private TreeNode nodeA;
    private TreeNode nodeB;

    public TreeNode bstSwappedNode(TreeNode root) {
        // write your code here
        inorder(root);
        
        if (nodeA != null) {
            int temp = nodeA.val;
                nodeA.val = nodeB.val;
                nodeB.val = temp;
        }
        return root;
    }

    private void inorder(TreeNode root) {

        if (root == null) {
            return;
        }    
        // if (root != null)
        inorder(root.left);

        // exec
        if (nodeA == null && root.val < lastNode.val) {
            nodeA = lastNode;
        } 
        if (nodeA != null && 
                    root.val < lastNode.val) {
            nodeB = root;
        }

        lastNode = root;
        inorder(root.right);
        
    }
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
            a.val = b.val;
            b.val = temp;
        return;
    }
}