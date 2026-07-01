class LRUCache {
    class Node
    {
        int key ; int value ;
        Node prev ; Node next ;
        Node(int key , int value)
        {
            this.key = key ; this.value = value ;
        }
    }
    int capacity ;
    HashMap<Integer,Node> map = new HashMap<>();
    Node head = null ; Node tail = null;
    public LRUCache(int capacity) {
        this.capacity = capacity ;
        this.head = new Node(0,0);
        this.tail = new Node(0,0);
        this.head.next = this.tail;
        this.tail.prev = this.head ;
    }
    public void insertAtFirst(Node node)
    {
        Node p = head ;
        Node q = head.next ;
        p.next = node;
        q.prev=node;
        node.next = q;
        node.prev = p;
    }
    public void delete(Node node)
    {
        Node p = node.prev ;
        Node q = node.next ;
        p.next =q;
        q.prev = p;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null) return -1;
        else
        {
            delete(node);
            insertAtFirst(node);
            return node.value ;
        }
        
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        if(node!=null)
        {
            node.value = value ;
            delete(node);
            insertAtFirst(node);
        }
        else 
        {
            Node newN = new Node(key,value);
            if(capacity>map.size())
            insertAtFirst(newN);
            else
            {
            map.remove(tail.prev.key);
            delete(tail.prev);
            insertAtFirst(newN);
            
            }
            map.put(key,newN);
        }
        
    }
}
