class StockSpanner {
	Stack<Integer> stack ;
	List<Integer> result ;
    public StockSpanner() {
        stack = new Stack<>();
		result = new ArrayList<>();
    }
    
    public int next(int price) {
        int count =0;
		while(!stack.isEmpty()&&stack.peek()<=price)
		{
				stack.pop();
				int last_val = result.get(result.size()-1);
				result.remove(result.size()-1);
				count =count +last_val;
			
		}
		result.add(count+1);
		stack.add(price);
		
		return count+1;
    }
}