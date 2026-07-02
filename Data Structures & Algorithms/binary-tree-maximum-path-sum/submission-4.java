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
    int max =Integer.MIN_VALUE ;
    public int f(TreeNode root)
    {
        if(root==null) return (Integer.MIN_VALUE)/10;
        int left = f(root.left);
        int right = f(root.right);
        int max_local = Math.max(Math.max(left+root.val,right+root.val),root.val);
        if(Math.max(left+root.val+right,max_local)>max) max =Math.max(left+root.val+right,max_local) ;
        return max_local;
    }
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        f(root);
        return max;
    }
}
