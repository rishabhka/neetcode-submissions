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
    int max_diameter= 0;
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
            if( left + right>max_diameter) 
            max_diameter=left + right ;
            return Math.max(left,right)+1;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0 ;
        int x = f(root);
        return max_diameter;
    }
}
