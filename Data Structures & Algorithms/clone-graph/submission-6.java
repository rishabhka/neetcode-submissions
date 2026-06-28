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
    public Node cloneGraph(Node orignal) {
        if(orignal==null)
        return null;
        HashMap<Node,Node> processed= new HashMap<>() ;
        Node root = new Node(orignal.val);
        
        Queue<Node> q = new LinkedList<>();
        q.add(orignal);
        processed.put(orignal,root);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            for(Node neigh : node.neighbors)
            {
                if(!processed.containsKey(neigh))
                {
                    Node newNode = new Node(neigh.val);
                    processed.put(neigh,newNode);
                    q.add(neigh);
                }
                processed.get(node).neighbors.add(processed.get(neigh));
            }
        }
        return root;
    }
}