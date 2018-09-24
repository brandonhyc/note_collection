/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } } 
 * Definition for singly-linked list. public class
 * ListNode { int val; 
 *      ListNode next; 
 *      ListNode(int x) { val = x; } }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        
        List<ListNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode tNode = root;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        while (tNode != null || !que.isEmpty()) {
            System.out.println(tNode);
            int size = que.size();
            // head node 
            tNode = que.poll();

            if (tNode.left != null) {
                que.offer(tNode.left);
            }
            if (tNode.right != null) {
                que.offer(tNode.right);
            }

            ListNode lNode = new ListNode(tNode.val);
            result.add(lNode);

            for (int i = 1; i < size; i++) {
                tNode = que.poll();
                lNode.next = new ListNode(tNode.val);

                if (tNode.left != null) {
                    que.offer(tNode.right);
                }
                if (tNode.right != null) {
                    que.offer(tNode.left);
                }
            }
        }
        return result;
    }
}