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
    int dia =0;
    public int diameter(TreeNode root)
    {
        if(root==null)
        return 0;
        else if(root.left==null&&root.right==null) return 1;
        else 
        {
            int left =  diameter(root.left);
            int right =  diameter(root.right);
            if(dia<left+right) dia = left+right ;
            return Math.max(left,right)+1;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return dia;
    }
}
