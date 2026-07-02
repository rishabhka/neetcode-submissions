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
    class Node
    {
        TreeNode root ;
        int level ;
        Node(TreeNode elem,int level)
        {
            this.root=elem;
            this.level = level ;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root==null ) return result ;
        List<Node> temp = new ArrayList<>();
        Queue<Node > q = new LinkedList<>();
        q.add(new Node(root,0) );
        // 1 2 3 4 5 6 7
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(node.root==null)
            continue ;
            temp.add(node);
            q.add(new Node(node.root.left,node.level+1));
            q.add(new Node(node.root.right,node.level+1));
        }
        List<Integer> list = new ArrayList<>();
        
        int prev = 0;
        for(int i=0;i<temp.size();i++)
        {
            Node node = temp.get(i) ;
            if(node.level!=prev)
            {
                result.add(new ArrayList<>(list));
                list = new ArrayList<>();
                list.add(node.root.val);
                prev = node.level;
            }
            else
            list.add(node.root.val);
        }
        result.add(new ArrayList<>(list));
        return result;
        
    }
}
