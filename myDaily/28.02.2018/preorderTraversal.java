public List<Integer> preorderTraversal(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();

    if (root == null) {
        return list;
    }

    stack.push(root);
    while (!stack.empty()) {
        TreeNode node = stack.pop();
        list.add(node.val);

        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }
    return list;
}