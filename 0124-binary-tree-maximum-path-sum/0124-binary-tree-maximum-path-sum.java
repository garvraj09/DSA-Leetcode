/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int lSum = Math.max(0, dfs(root.left));
        int rSum = Math.max(0, dfs(root.right));

        int currSum = lSum + rSum + root.val;

        maxSum = Math.max(maxSum, currSum);

        return Math.max(lSum, rSum) + root.val;
    }
}