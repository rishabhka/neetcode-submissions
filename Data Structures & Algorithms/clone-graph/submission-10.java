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
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        HashMap<Integer,Node> map= new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node clone = new Node(node.val);
        map.put(node.val,clone);
        while(!q.isEmpty())
        {
            Node src = q.poll();
            Node dst = map.get(src.val);
            for(Node neigh : src.neighbors)
            {
                if(!map.containsKey(neigh.val))
                {
                    Node newNode = new Node(neigh.val);
                    map.put(neigh.val,newNode);
                    dst.neighbors.add(newNode) ;
                    q.add(neigh);
                }
                else
                dst.neighbors.add(map.get(neigh.val)) ;
            }
        }
        return clone;
    }
}