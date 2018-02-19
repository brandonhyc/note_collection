//19.02.2018 the second time
public List<Integer> preorderTraversal(TreeNode root) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> preoder = new List<>();

    stack.push(root);

    while (!stack.isEmpty()){
        TreeNode node = stack.pop();
        preoder.push(root);
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
    }

    return preoder;
}