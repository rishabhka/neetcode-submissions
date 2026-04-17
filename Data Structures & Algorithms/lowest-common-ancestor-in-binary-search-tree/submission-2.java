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
    public void getPath(TreeNode root,TreeNode p,List<TreeNode> list1)
    {
        if(root==null)
        return ;
        else if(root.val==p.val)
        {
        list1.add(root);
        return ;
        }
        else
        {
            list1.add(root);
            if(root.val<p.val)
            getPath(root.right,p,list1);
            else
            getPath(root.left,p,list1);
        }


    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        getPath(root,p,list1);
        getPath(root,q,list2);

    
        TreeNode next = root ;
        for(int i=0;i<Math.min(list2.size(),list1.size());i++)
        {
        if(list1.get(i)==list2.get(i))
        next = list1.get(i) ;
        else break ;
        }


        return next ;
    }
}
