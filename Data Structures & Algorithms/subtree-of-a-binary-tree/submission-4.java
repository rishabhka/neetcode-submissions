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
    public boolean checkIfEqual(TreeNode root,TreeNode subRoot) 
    {
        if(root==null&&subRoot==null)
        return true ;
        else if(root==null||subRoot==null)
        return false ;
        else if(root.val==subRoot.val)
        {
            return checkIfEqual(root.left,subRoot.left)&&checkIfEqual(root.right,subRoot.right);
        }
        else return false ;

    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null)
        return true;
        else if(subRoot==null) 
        return true ;
        else if(root==null)
        return false ;
        else if(checkIfEqual(root,subRoot))
        return true ;
        else return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot) ;
    }
}
