public List<String> binaryTreePaths(TreeNode root) {
    List<String> paths = new ArrayList<>();

    //exit
    if (root == null) {
        return paths;
    }

    if (root.left == null && root.right == null) {
        paths.add(root + "");
        return paths;
    }


    List<String> left = binaryTreePaths(root.left);
    List<String> right = binaryTreePaths(root.right);

    //conquer
    for (String path : left) {
        paths.add( root.val + "->" + path);
    }

    for (String path : right) {
        paths.add(root.val + "->" + path);
    }

    return paths;
}