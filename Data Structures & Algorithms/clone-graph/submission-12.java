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
        HashMap<Integer,Node> map = new HashMap<>();
        Node root = new Node(node.val);
        Queue<Node> q = new LinkedList<>();
        q.offer(node) ;
        map.put(node.val,root) ;
        while(!q.isEmpty())
        {
            Node orignal = q.poll();
            Node copy = map.get(orignal.val) ;
            for(Node neigh : orignal.neighbors)
            {
                Node neighCopy = map.getOrDefault(neigh.val,new Node(neigh.val)) ;
                copy.neighbors.add(neighCopy) ;
                if(map.containsKey(neighCopy.val)) continue ;
                map.put(neigh.val,neighCopy) ;
                q.offer(neigh) ;
            }

        }
        return root ;
    }
}