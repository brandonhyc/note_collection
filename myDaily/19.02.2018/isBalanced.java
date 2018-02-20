//19.02.2018

class ResultType {
        boolean isBalanced; 
        int maxDepth;
    
        ResultType(boolean isBalanced, int maxDepth) {
            this.maxDepth = maxDepth;
            this.isBalanced = isBalanced;
        }
    }
    
public class Solution {
    
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }
    
    public ResultType helper(TreeNode root) {
        boolean isBalanced;
    
        //exit
        if (root == null) {
            return new ResultType(true, 0);
        }
    
        //divide and conquer
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
    
        //merge
        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1); 
        }
    
        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }
    
        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }