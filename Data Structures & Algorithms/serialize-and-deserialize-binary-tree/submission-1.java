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

public class Codec {
    String s = "";
    // Encodes a tree to a single string.
    public void preOrder(TreeNode root)
    {
        if(root==null) 
        {
        s=s+",N" ;
        return;
        }
        s=s+","+root.val;
        preOrder(root.left);
        preOrder(root.right);
    }
    public String serialize(TreeNode root) {
        preOrder(root);
        System.out.println(s.substring(1,s.length()));
        return s.substring(1,s.length()) ;
    }

    // Decodes your encoded data to tree.
    int ctr=0;
    public TreeNode couple(String [] nodes,int i)
    {
        
        if(nodes[i].equals("N")) 
        {
            ctr++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i]));
        ctr++ ;
        node.left =couple(nodes,ctr);
        node.right = couple(nodes,ctr);
        return node;
    }
    public TreeNode deserialize(String data) {
        String [] nodes = data.split(",");
        return couple(nodes,0);
    }
}
