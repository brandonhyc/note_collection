/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return generateBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode generateBST(int[] nums, int left, int right) {
        
        if (left > right) {
            return null;
        }
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = generateBST(nums, left, mid - 1);
        root.right = generateBST(nums, mid + 1, right);
        
//         0 1 -> 0
//         0 1 