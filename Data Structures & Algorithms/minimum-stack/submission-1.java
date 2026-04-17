class MinStack {
    int min = Integer.MAX_VALUE ;
    Deque<Node> stack ;
    class Node
    {
        int val , minVal ;
        Node(int m , int n)
        {
            val = m;
            minVal = n;
        }
    }

    public MinStack() {
        stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if(val<min)
        min = val;
        Node node = new Node(val,min);
        stack.push(node);
    }
    
    public void pop() {
        stack.pop();
        if(stack.isEmpty())
        min = Integer.MAX_VALUE ;
        else
        min = stack.peek().minVal;
    }
    
    public int top() {
        Node n = stack.peek();
        return n.val;
    }
    
    public int getMin() {
        Node n = stack.peek();
        return n.minVal;
    }
}
