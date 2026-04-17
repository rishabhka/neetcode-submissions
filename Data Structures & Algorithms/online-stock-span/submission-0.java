class StockSpanner {
	List<Integer> result ;
    public StockSpanner() {
        result = new ArrayList<>();
    }
    
    public int next(int price) {
        result.add(price) ;
		int count =0;
		for(int i=result.size()-1;i>=0;i--)
		{
			if(price>=result.get(i))
				count ++;
			else break ;
		
		}
		return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */