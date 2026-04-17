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
    public void inorder(TreeNode root, List<Integer> list)
    {
        if(root == null)
        return ;
        else if (root.left==null&&root.right==null)
        {
        list.add(root.val);
        return;
        }
        else
        {
          inorder(root.left,list);
          list.add(root.val);
          inorder(root.right,list);
        }
    }
    public boolean isValidBST(TreeNode root) {
        if(root == null)
        return true ;
        if(root.left == null && root.right == null)
        return true;
        else
        {
            List<Integer> list = new ArrayList<>();
            inorder(root,list);
            int current = Integer.MIN_VALUE;
            for(int number : list)
            {
                if(number > current)
                {
                    current = number ;
                }
                else return false;
            }
        }
        return true;
    }
}
