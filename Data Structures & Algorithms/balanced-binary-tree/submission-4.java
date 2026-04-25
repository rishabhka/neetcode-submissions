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
    public int f(TreeNode root)
    {
        if(root==null)
        return 0 ;
        else if(root.left==null&&root.right==null)
        return 1 ;
        else
        {
            int left = f(root.left);
            int right = f(root.right);
            if(Math.abs(right-left)>1)
            isBalanced=false;
            return Math.max(left,right)+1;
        }

    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true ;
        f(root);
        return isBalanced ;
    }
}
