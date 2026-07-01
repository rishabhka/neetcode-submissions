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
// 3- > 5,3
//4 -> 5,3,4
//8-> 5,8
class Solution {
    public void findPath(TreeNode root,TreeNode p,List<TreeNode> list)
    {
        if(root==null) return ;
        list.add(root);
        if(root.val==p.val) return ;
        else if(root.val<p.val)
        findPath(root.right,p,list) ;
        else
        findPath(root.left,p,list) ;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();
        findPath(root,p,list1);
        findPath(root,q,list2);
        TreeNode same = list1.get(0);

        for(int i=0;i<Math.min(list1.size(),list2.size());i++)
        {
            if(list1.get(i)==list2.get(i))
            same = list1.get(i) ;
            else break;
        }
        return same;
    }
}
