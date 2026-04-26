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
    public void f(TreeNode root,TreeNode p,List<TreeNode> pPath) 
    {
        if(root==null)
        return ;
        pPath.add(root);
        
        if(root.val == p.val) return;
        
        else if(root.val>p.val)
        {
         f(root.left,p,pPath);
        }
        else
         f(root.right,p,pPath);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        f(root,p,pPath);
f(root,q,qPath);
System.out.println("pPath: " + pPath.stream().map(n->n.val+"").collect(Collectors.joining(",")));
System.out.println("qPath: " + qPath.stream().map(n->n.val+"").collect(Collectors.joining(",")));
        TreeNode prev = root;
        for(int i=0;i<Math.min(pPath.size(),qPath.size());i++)
        {
            if(pPath.get(i) == qPath.get(i))
            {
                prev = pPath.get(i);
                continue ;
            }
            else 
            break;
        }
        return prev;
    }
}
