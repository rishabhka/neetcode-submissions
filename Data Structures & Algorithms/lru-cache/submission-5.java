class LRUCache {
    class Node
    {
        int val ;int key ; Node left=null ; Node right = null;
        Node() { } 
        Node(int key ,int val) {this.val = val ;this.key=key;}
    }
    HashMap<Integer,Node> map ;
    int curr = 0; int max_cap = 0; 
    Node front = new Node() ; Node rear = new Node();
    public LRUCache(int capacity) {
        map = new HashMap<>();
        max_cap = capacity ;
        front.right = rear ;
        rear.left = front ;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1 ;
        removeFromAnywhere(key);
        insertFront(map.get(key)) ;
        return map.get(key).val ;
    }
    public void insertFront(Node node) 
    {
        Node temp = front.right ;
        node.right = front.right ;
        node.left = front;
        front.right = node;
        temp.left = node ;
    }
    public int deletelast()
    {
        int key = rear.left.key ;
        Node temp = rear.left.left ;
        rear.left = temp ;
        temp.right = rear ;
        return key ;
    }
    public void removeFromAnywhere(int  key )
    {
        Node node =  map.get(key) ;
        Node l = node.left ;
        Node r = node.right ;
        l.right = r;
        r.left = l;
    }
    public void put(int key, int value) {
        if(!map.containsKey(key))
        {
            if(curr<max_cap) 
            {
                curr ++;
                Node node = new Node(key,value);
                map.put(key,node);
                insertFront(node) ;
            }
            else 
            {
                int del = deletelast() ;
                map.remove(del);
                Node node = new Node(key,value);
                map.put(key,node);
                insertFront(node) ;
            }
        }
        else
        {
            Node node = map.get(key);
            node.val = value;      
            removeFromAnywhere(key);
            insertFront(node) ;
        }
    }
}
