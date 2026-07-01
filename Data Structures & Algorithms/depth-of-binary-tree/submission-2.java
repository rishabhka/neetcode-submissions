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
    public int maxHeight(TreeNode root)
    {
        if(root==null) return 0;
        else if(root.left==null&&root.right==null) return 1;
        else return Math.max(maxHeight(root.left),maxHeight(root.right)) +1 ;

    }
    public int maxDepth(TreeNode root) {
        return maxHeight(root);
    }
}
