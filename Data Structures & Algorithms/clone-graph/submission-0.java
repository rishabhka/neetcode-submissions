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
        if(node==null)
        return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node root = new Node(node.val);
        map.put(node,root);
        while(!q.isEmpty())
        {
            Node orignalNode = q.poll();
            Node copiedNode = map.get(orignalNode) ;
            for(int i=0;i<orignalNode.neighbors.size();i++)
            {
                
                if(!map.containsKey(orignalNode.neighbors.get(i)))
                {
                    map.put(orignalNode.neighbors.get(i),new Node(orignalNode.neighbors.get(i).val));
                    q.add(orignalNode.neighbors.get(i));
                }
                copiedNode.neighbors.add(map.get(orignalNode.neighbors.get(i)));
            }
        }
        return root;
    }
}