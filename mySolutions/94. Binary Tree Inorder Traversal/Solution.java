/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

// Given binary tree {1,#,2,3}; 
//             return [1,3,2].
//    1
//     \
//      2
//     /
//    3

public class Solution {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here

        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        TreeNode ptr = root;

        while (!stack.empty() || ptr != null) {
            while (ptr != null) {
                stack.add(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            func(list, ptr);
            ptr = ptr.right;
        }
        return list;
    }
    
    private void func(List<Integer> list, TreeNode node) {
        list.add(node.val);
        System.out.print(node.val + " ");
    }
}