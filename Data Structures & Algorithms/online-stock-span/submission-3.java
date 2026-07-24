class StockSpanner {
    Deque<int []> stack ;
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        if(stack.isEmpty()||stack.peek()[0]>price) 
        { 
            stack.push(new int []{price,0}); 
            return 1 ;
        } 
        else 
        {
            int cnt =0 ;
            while(!stack.isEmpty()&&stack.peek()[0]<=price)
            {
                cnt = cnt + stack.pop()[1] + 1; 
            }
            stack.push(new int []{price,cnt}) ;
            return cnt+1 ;
        }
        
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */