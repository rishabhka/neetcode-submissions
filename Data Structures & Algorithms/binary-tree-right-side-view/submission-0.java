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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root==null)
        return result;
        q1.add(root);
        TreeNode lastEl = root;
        while(!q1.isEmpty() || !q2.isEmpty())
        {
            boolean flag = false;
            while(!q1.isEmpty())
            {
                TreeNode temp = q1.poll();
                lastEl = temp ;
                if(temp.left!=null)
                q2.add(temp.left);
                if(temp.right!=null)
                q2.add(temp.right);
            }
            result.add(lastEl.val);
            while(!q2.isEmpty())
            {
                flag = true ;
                TreeNode temp = q2.poll();
                lastEl = temp ;
                if(temp.left!=null)
                q1.add(temp.left);
                if(temp.right!=null)
                q1.add(temp.right);
            }
            if(flag)
            result.add(lastEl.val);
        }
        return result ;
    }
}
