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
    int count =1;
    public void countNode(TreeNode root, int maxInPath)
    {
        int max = maxInPath;
        if(root==null) return ;
        else if(root.val>=max)
        {
            max = root.val;
            count ++;
        }
        countNode(root.left,max);
        countNode(root.right,max);
    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0 ;
        countNode(root.left,root.val);
        countNode(root.right,root.val);
        return count ;
    }
}
