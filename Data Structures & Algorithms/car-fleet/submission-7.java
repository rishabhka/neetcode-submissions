class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<position.length;i++)
		{
			map.put(position[i],speed[i]) ;
		}
		Arrays.sort(position);
		for(int i=0;i<position.length;i++)
		{
			speed[i]= map.get(position[i]) ;
		}
		
		double [] time = new double [position.length] ;
		for(int i=0;i<position.length;i++)
		{
			time[i] = (target - position[i]*1.0)/(double) speed[i];
		}
		Stack<Double> stack = new Stack<>();
		int count = 0;
		for(int i= time.length-1;i>=0;i-- )
		{
			if(stack.isEmpty()||time[i]>stack.peek())
            {
			count ++ ;
			stack.push(time[i]);
            }
		}
		
		
		return count ;
		
        
    }
}
