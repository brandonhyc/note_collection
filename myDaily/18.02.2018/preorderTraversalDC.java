public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();

    if (root == null) {
        return res;
    }


    ArrayList<Integer> left = preorderTraversal(root.left);
    ArrayList<Integer> right = preorderTraversal(root.right);

    //conquer
    res.add(root.val);
    res.addAll(left);
    res.addAll(right);
    return res;

}