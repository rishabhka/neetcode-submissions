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


    public List<List<Integer>> levelOrder(TreeNode root) {

        
        
       List<List<Integer>> result = new ArrayList<>();
       Queue<TreeNode> p = new LinkedList<>();
       Queue<TreeNode> q = new LinkedList<>();
       if(root==null)
       return result;
       p.add(root);

       while((!p.isEmpty())|| !q.isEmpty())
       {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
       while(!p.isEmpty())
       {
        TreeNode temp = p.poll();
        list1.add(temp.val);
        if(temp.left!=null)
        q.add(temp.left);
        if(temp.right!=null)
        q.add(temp.right);
       }
       result.add(list1);
       while(!q.isEmpty())
       {
        TreeNode temp = q.poll();
        list2.add(temp.val);
        if(temp.left!=null)
        p.add(temp.left);
        if(temp.right!=null)
        p.add(temp.right);
       }
       if(!list2.isEmpty())
        result.add(list2);
       }
       return result;
}
}