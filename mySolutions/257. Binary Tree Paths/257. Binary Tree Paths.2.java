/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        list.add(root.val);
        backtrack(root, results, list);
        
        return results;
    }
    
    private void backtrack(TreeNode root, List<String> results, List<Integer> list)  {

        if (root.left == null && root.right == null) {
            
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            
            for (int num : list) {
                sb.append(prefix);
                sb.append(num);
                prefix= "->";
            }
            
            results.add(sb.toString());
            return;
        }
        if (root.left != null) {
            list.add(root.left.val);
            backtrack(root.left, results, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            list.add(root.right.val);
            backtrack(root.right, results, list);
            list.remove(list.size() - 1);
        }
        
    }
}   