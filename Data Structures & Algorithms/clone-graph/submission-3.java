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
        if(set.containsKey(node))
        return ;
        set.put(node,root);
        for(Node neigh: node.neighbors)
        {
            if(!set.containsKey(neigh))
            {
                Node newNode = new Node(neigh.val);
                root.neighbors.add(newNode);
                f(neigh,newNode) ;
            }
            else
            {
                Node newNode = set.get(neigh);
                root.neighbors.add(newNode);
            }
        }
        return  ;
    }
    HashMap<Node,Node> set = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null )
        return null;
        Node root = new Node(node.val);
        f(node,root);
        return root;
    }
}