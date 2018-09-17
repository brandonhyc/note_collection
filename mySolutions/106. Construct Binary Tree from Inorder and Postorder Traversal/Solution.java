/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */


public class Solution {
    /**
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */

    /**
     * inorder：[ d e b g f "a" c ]
     *           >--left--<    >r<
     * postorder：[ e d g f b  c "a" ]
     *             >--left--< >r<            
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here

        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }
        if (postorder.length != inorder.length) {
            return null;
        }

        return divideAndConquer(inorder, postorder);
    }
    
    private TreeNode divideAndConquer(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }

        int root = postorder[postorder.length - 1];
        int index = 0;

        // find the head
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root) {
                index = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);

        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);

        TreeNode result = new TreeNode(root);
        result.left = divideAndConquer(inLeft, postLeft);
        result.right = divideAndConquer(inRight, postRight);

        return result;
    }
}