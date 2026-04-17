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
    int max_node = -10000;
    public int func(TreeNode root)
    {
      if(root==null)
        return -10000;
        else 
        {
            int max_value = 0;
            int left_node = func(root.left);
            int right_node = func(root.right);
            max_value =  Math.max(left_node + root.val,Math.max(right_node + root.val,root.val));
            int kp = Math.max( left_node + right_node + root.val,Math.max(max_value,Math.max(left_node,right_node)));
            if(kp>max_node)
            max_node = kp;
             return max_value;
        }
    }
    public int maxPathSum(TreeNode root) {
        func(root);
        return max_node;
    }
}
