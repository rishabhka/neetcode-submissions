class MinStack {
    class Node
    {
        int value ;
        int min ;
        Node(int value ,int min)
        {
            this.value = value ;
            this.min = min ;
        }
    }
    Stack<Node> stack = new Stack<>();
    int curr_min = Integer.MAX_VALUE ;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
        {
            stack.push(new Node(val,val));
            curr_min = val;
        }
        else
        {
            curr_min = Math.min(curr_min,val);
            stack.push(new Node(val,curr_min));
        }
    }
    
    public void pop() {
        stack.pop();
        if(!stack.isEmpty())
        curr_min = stack.peek().min;
    }
    
    public int top() {
        return stack.peek().value;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
