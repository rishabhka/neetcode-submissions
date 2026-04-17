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
    public void inorder(TreeNode root , List<Integer> list)
    {
        if(root == null)
        return ;
        else if(root.left==null&&root.right==null)
        {
        list.add(root.val);
        return ;
        }
        else
        {
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
        return 0;
        inorder(root,list);
        return list.get(k-1);

    }
}
