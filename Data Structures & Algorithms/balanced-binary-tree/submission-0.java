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
    boolean isBalanced = true ;
    public int dfs(TreeNode root)
    {
        if(root==null)
        return 0;
        else if(root.left==null&&root.right==null)
        return 1 ;
        else
        {
            int leftHeight = dfs(root.left) ; 
            int rightHeight = dfs(root.right)  ;
            if(Math.abs(leftHeight-rightHeight)>=2)
            isBalanced = false;
            return Math.max(leftHeight,rightHeight) + 1;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true;
        else if(root.left==null&&root.right==null)
        return true ;
        else
        {
            int roottDiff = dfs(root);
            return isBalanced ;
        }
    }
}
