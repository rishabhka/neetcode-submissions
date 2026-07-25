class MyCircularQueue {
    class Node
    {
        int val ; Node left = null; Node right = null ;
        Node(){ }
        Node(int val) {this.val = val;}
    }
    int size = 0; int max_size ; Node front = null ; Node rear = null;
    public MyCircularQueue(int k) {
        max_size= k; 
        front = new Node ();
        rear = new Node ();
        front.right=rear;
        rear.left = front ;
    }
    
    public boolean enQueue(int value) {
        if(size==max_size) return false ;
        else
        {
            size ++ ;
            Node node = new Node(value) ;
            if(front.right==null) { front.right = node ; rear.left = node ; }
            else {
                Node temp = rear.left ;
                temp.right = node ;
                node.left = temp;
                node.right = rear ;
                rear.left = node ;
            }
            return true ;
        }
    }
    
    public boolean deQueue() {
        if(size==0) return false ;
        else
        {
            size -- ;
            if(front.right==rear.left)
            {
                front.right = rear ; rear.left = front ;
            }
            else
            {
                Node temp = front.right.right ;
                temp.left = front ;
                front.right = temp ;
            }
            return true ;
        }
    }
    
    public int Front() {
        if(size==0) return -1 ;
        else return front.right.val;
    }
    
    public int Rear() {
        if(size==0) return -1 ;
        else return rear.left.val;
    }
    
    public boolean isEmpty() {
        if(size==0) return true ;
        else return false;
    }
    
    public boolean isFull() {
        if(size==max_size) return true ;
        else return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */