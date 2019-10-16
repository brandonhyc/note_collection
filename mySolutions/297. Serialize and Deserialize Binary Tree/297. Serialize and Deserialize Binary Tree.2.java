/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // level traversal
        List<Integer> order = new ArrayList<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                order.add(root == null ? null : root.val);
                if (root != null) {
                    queue.offer(root.left);
                    queue.offer(root.right);
                }
            }
        }
        // System.out.printf("order: %s\n", order.toString());
        return order.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strArr = data.substring(1, data.length() - 1).split(", ");
        if (strArr.length == 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (String str: strArr) {
            if (str.equals("null")) {
                list.add(null);
            }
            else {
                list.add(Integer.parseInt(str));
            }
        }
        
        // System.out.printf("list: %s\n", list.toString());
        return buildTree(list, 0);
    }
    
    private TreeNode buildTree(List<Integer> list, int index) {
        if (index > list.size() - 1 || list.get(index) == null) {
            return null;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode dummy = new TreeNode(list.get(0));
        TreeNode root = dummy;
        queue.offer(root);
        
        int i = 1;
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root == null) {
                continue;
            }
            // pull left
            Integer left = list.get(i);
            if (left != null) {
                root.left = new TreeNode((int) left);
                queue.offer(root.left);
            }
            i++;
            
            Integer right = list.get(i);
            if (right != null) {
                root.right = new TreeNode((int) right);
                queue.offer(root.right);
            }
            i++;
            
        }

        return dummy;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));