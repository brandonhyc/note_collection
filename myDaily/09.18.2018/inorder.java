public class inorder {
    



    public List<Integer> inorder(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new stack<>();
        
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.add(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node);
            node = node.right;
        }
        return list;
    } 
}