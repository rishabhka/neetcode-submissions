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
    public void inorder(TreeNode root, List<TreeNode> list)
    {
        if(root==null)
        return ;
        else if (root.left==null&&root.right==null)
        {
        list.add(root);
        return;
        }
        else
        {
            list.add(root);
            inorder(root.left,list);
            inorder(root.right,list);
        }
    }
    public boolean check(TreeNode rootList, TreeNode subRoot)
    {
        System.out.println("hell");
        if(rootList==null&&subRoot==null)
        return true;
        if(rootList!=null&&subRoot==null)
        return false;
        if(rootList==null&&subRoot!=null)
        return false;
        else
        {
            if(rootList.val!=subRoot.val)
            return false;
            else
            return check(rootList.left,subRoot.left)&&check(rootList.right,subRoot.right);
        }

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null)
        return true;
        if(root!=null&&subRoot==null)
        return false;
        if(root==null&&subRoot!=null)
        return false;
        else
        {
            List<TreeNode> rootList = new ArrayList<>();
            inorder(root,rootList); 
            for(int i=0;i<rootList.size();i++)
            {
                if(check(rootList.get(i),subRoot))
                return true;
            }
        }
        return false;
    }
}
