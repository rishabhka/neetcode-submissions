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
    public int f(TreeNode root)
    {
        if(root==null)
        return 0;
        if(root.left==null&&root.right==null)
        return 0;
        else
        {
            int left =0 , right =0;
            if(root.left!=null)
            left = f(root.left)+1;
            if(root.right!=null)
            right = f(root.right)+1;
            if(diameter<left+right)
            diameter = left + right ;
            return Math.max(left,right);
        }
    }
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
        return 0;
        else if(root.left==null&&root.right==null)
        return 0;
        else
        {
            int rootDiameter = f(root);
            return diameter;
        }
    }
}