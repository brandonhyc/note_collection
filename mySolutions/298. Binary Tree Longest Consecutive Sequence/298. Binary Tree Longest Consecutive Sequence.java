class Solution {
    int maxSeqCount = 0;
    
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        inorderAsc(root, 1, root.val);
        
        return maxSeqCount;    
    }
    
    private void inorderAsc(TreeNode root, int count, int prevVal) {
        
        maxSeqCount = Math.max(maxSeqCount, count);
        
        if (root == null) {
            return;
        }
        
        inorderAsc(root.left, (prevVal + 1 == root.val) ? count + 1 : 1, root.val);
        inorderAsc(root.right, (prevVal + 1 == root.val) ? count + 1 : 1, root.val);
        
    } 
}