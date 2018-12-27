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
     * @param inorder: A list of integers that inorder traversal of a tree
     * @param postorder: A list of integers that postorder traversal of a tree
     * @return: Root of a tree
     */
    private int findPosition(int[] arr, int start, int end, int key) {
        for (int i = start; i < end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    private TreeNode myBuildTree(int[] inorder, int instart, int inend,
                                int[] preorder, int prestart, int preend) {
        if (instart > inend) {
            return null;
        }               
        TreeNode root = new TreeNode(preorder[prestart]);

        int position = findPosition(inorder, instart, inend, preorder[prestart]);             

        root.left = myBuildTree(inorder, instart, )
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here

        if (inorder.length != preorder.length) {
            return null;
        }
        return myBuildTree(inorder, 0, inorder.length - 1, preorder, preorder.length -1);
    }
}