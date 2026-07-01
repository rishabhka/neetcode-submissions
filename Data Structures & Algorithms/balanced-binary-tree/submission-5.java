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
    public int checkBalance(TreeNode root,boolean [] res)
    {
        if(root== null) return 0 ;
        else if(root.left==null&&root.right==null) return 1 ;
        else
        {
            int leftsub = checkBalance(root.left,res);
            int rightsub = checkBalance(root.right,res);
            if(Math.abs(leftsub-rightsub)>1) 
            { 
                res[0] = true;
            }
            return Math.max(leftsub,rightsub) +1;
        }

    }
    public boolean isBalanced(TreeNode root) {
        boolean [] res = new boolean [1];
        checkBalance(root,res);
        return !res[0];
    }
}
