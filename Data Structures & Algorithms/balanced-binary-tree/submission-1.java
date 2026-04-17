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
    Boolean flag = true ;
    public int f(TreeNode root)
    {
        if(root==null)
        return 0 ;
        else if(root.left==null&&root.right==null)
        return 1 ;
        else
        {
            int left_ht = f(root.left) +1 ;
            int right_ht = f(root.right) +1 ;
            if(Math.abs(left_ht-right_ht)>1)
            flag = false;
            return Math.max(left_ht,right_ht) ;
        }
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        return true ;
        f(root);
        return flag ;
    }
}
