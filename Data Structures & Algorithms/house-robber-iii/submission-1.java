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
    public int dfs(TreeNode root,HashMap<TreeNode,Integer> dp)
    {
        if(root== null) return 0 ;
        else if(dp.containsKey(root)) return dp.get(root);
        int res = root.val ;
        if(root.left!=null){
            res = res + dfs(root.left.left,dp ) + dfs(root.left.right ,dp) ;
        }
        if(root.right!=null){
            res = res + dfs(root.right.left,dp ) + dfs(root.right.right,dp ) ;
        }
        dp.put(root, Math.max(res,dfs(root.left,dp)+dfs(root.right,dp)) );
        return dp.get(root);
    }
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> dp = new HashMap<>();
        return dfs(root,dp) ;
    }
}