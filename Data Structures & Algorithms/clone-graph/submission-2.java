/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void f(Node node,Node root)
    {
        if(node == null )
        return ;
        if(set.containsKey(node.val))
        return ;
        set.put(root.val,root);
        for(Node neigh: node.neighbors)
        {
            Node newNode = null ;
            if(set.containsKey(neigh.val))
            newNode = set.get(neigh.val);
            else newNode = new Node(neigh.val);
            root.neighbors.add(newNode);
            
            f(neigh,newNode) ;
        }
        return  ;
    }
    HashMap<Integer,Node> set = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null )
        return null;
        Node root = new Node(node.val);
        // set.put(root.val,root);
        f(node,root);
        return root;
    }
}