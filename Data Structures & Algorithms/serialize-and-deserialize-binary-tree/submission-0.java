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
     public void dfsSerial(TreeNode root , List<String> list)
     {
       if(root==null)
       {
       list.add("N") ;
       return;
       }
       else
       {
        list.add(String.valueOf(root.val));
        dfsSerial(root.left,list);
        dfsSerial(root.right,list);
       }
     }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerial(root,list);
        String x = String.join(",",list);
        System.out.println(x);
        return x;
        
    }
    int ptr = 0;

    public TreeNode dfsDeserial(String [] list)
    {
      System.out.println(list[ptr]);
      if(list[ptr].equals("N")||ptr==list.length)
      return null;
      else
      {
        TreeNode newNode = new TreeNode(Integer.parseInt(list[ptr]));
        ptr++;
        newNode.left = dfsDeserial(list);
        ptr++;
        newNode.right = dfsDeserial(list);
        return newNode;
      }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] list = data.split(",");
        return dfsDeserial(list);

    }
}
