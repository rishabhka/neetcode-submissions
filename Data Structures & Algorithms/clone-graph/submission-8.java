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
        Boolean flag = map.containsKey(g.val) ;
        if(!flag)
        map.put(g.val,new Node(g.val));
        Node destNode = map.get(g.val) ;
        dst.neighbors.add(destNode) ;
        if(!flag)
        dfs(g,destNode,map) ;
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