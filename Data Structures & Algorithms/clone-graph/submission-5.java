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
        HashSet<Node> visited = new HashSet<>();
        Node root = new Node(orignal.val);
        
        
        
        // List<Node> neighbors = node.neighbors;
        Queue<Node> q = new LinkedList<>();
        q.add(orignal);
        processed.put(orignal,root);
        while(!q.isEmpty())
        {
            Node node = q.poll();
            if(visited.contains(node))
            continue ;
            visited.add(node);
            Node newNode = null;
            if(processed.containsKey(node))
            newNode = processed.get(node);
            else
            newNode = new Node(node.val);
            processed.put(node,newNode);
            for(int i=0;i<node.neighbors.size();i++)
            {
                Node neigh = node.neighbors.get(i);
                Node newneigh =null;
                if(!processed.containsKey(neigh))
                newneigh = new Node(neigh.val);
                else newneigh = processed.get(neigh);
                newNode.neighbors.add(newneigh);
                processed.put(neigh,newneigh);
                q.add(neigh);
            }
        }
        return root;
    }
}