// 19.02.2018
private int subtreeSum = Integer.MAX_VALUE;
private TreeNode minSubtree = null;

public TreeNode findSubtree(TreeNode root) {
    helper(root);
    return minSubtree;
}
 
public int helper(TreeNode root) {
    int sum;

    if (root == null) {
        return 0;
    }

    //divide and conquer
    int left = helper(root.left);
    int right = helper(root.right);

    //merge
    sum = left + right + root.val;
    if (sum < subtreeSum) {
        subtreeSum = sum;
        minSubtree = root;
    }

    return sum;
}     