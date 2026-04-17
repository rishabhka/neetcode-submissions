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
    public void traverse(TreeNode root,TreeNode p,List<TreeNode> list)
    {
        if(root==null)
        return ;
        else
        {
            list.add(root);
            if(root.val==p.val)
            return ;
            else if(root.val<p.val)
            traverse( root.right, p, list);
            else
            traverse( root.left, p, list);
            
        }
        return ;
        

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        traverse(root,p,list1);
        traverse(root,q,list2);
        // for(int i=0;i<list1.size();i++)
        // System.out.println(list1.get(i));
        // for(int i=0;i<list2.size();i++)
        // System.out.println(list2.get(i));
        int min = Math.min(list1.size(),list2.size());
        TreeNode value = null;
        for(int i=0;i<min;i++)
        {
            if(list1.get(i).val==list2.get(i).val)
            value = list1.get(i);
        }
        return value;
    }
}
