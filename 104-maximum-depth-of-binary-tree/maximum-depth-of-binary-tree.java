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
    int max ;
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root);
        return this.max+1;
    }

    public int dfs(TreeNode root){

        if(root==null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(left, right);

        return Math.max(left,right)+1;

    }
}