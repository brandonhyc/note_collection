/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */

    // 对于普通的二叉树来说，某个p结点的后继的计算方式是（画图容易理解）：
    // 首先必须得确定p存在于root中
    // 分类讨论一: 若p结点有右子树，则后继为 右子树的最左结点
    // 分类讨论二: 若p结点没有右子树，则后继为从target->root的路径中，第一次发生右拐的结点
    //（分类讨论二等价于：从root->target的路径中，最后一次发生左拐的结点）
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here

        if (root == null || p == null) {
            return null;
        }

        TreeNode successor = null;
        TreeNode t = root;
        while (t != null) {
            if (t.val == p.val) {
                break;
            } else if (t.val < p.val) {
                t = t.right;
            } else {
                successor = t;
                t = t.left;
            }
        }

        // 如果p不存在，其后继为null
        if (t == null) {
            return null;
        }
        
        // else 则p存在，此时t==p，如果p没有右孩子，则直接返回上面获得的后继，即分类讨论二
        if (p.right == null) {
            return successor;
        }
        
        // 否则，p的后继即为其右子树的最左节点，即分类讨论一
        p = p.right;
        while (p.left != null) {
            p = p.left;
        }
        return p    ;


    }
}