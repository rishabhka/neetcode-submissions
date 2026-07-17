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

public class Solution {
    public  void dfs(Node src,Node dst,HashMap<Integer,Node> map)
    {
        for(Node g : src.neighbors)
        {
        if(!map.containsKey(g.val))
        {
            Node node = new Node(g.val);
            map.put(g.val,node);
            dst.neighbors.add(node);
            dfs(g,node,map);
        }
        else
        dst.neighbors.add(map.get(g.val));
        }
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null ;
        Node graph = new Node(node.val);
        HashMap<Integer,Node> map = new HashMap<>();
        map.put(node.val,graph);
        dfs(node,graph,map);
        return graph ;
    }
}