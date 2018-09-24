/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } } Definition for singly-linked list. public class
 * ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> results = new ArrayList<>();

        if (root == null) {
            return results;
        }
        Queue<TreeNode> que = new LinkedList<>();
        TreeNode treeNode = root;
        que.offer(root);
        
        while (!que.isEmpty()) {
            ListNode dummy = new ListNode(-1);
            ListNode nodePtr = dummy;
            
            int size = que.size();

            for (int i = 0; i < size; i++) {
                treeNode = que.poll();
                nodePtr.next = new ListNode(treeNode.val);
                nodePtr = nodePtr.next;

                if (treeNode.left != null) {
                    que.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    que.offer(treeNode.right);
                }
            }
            
            results.add(dummy.next);
        }

        return results;
    }
}