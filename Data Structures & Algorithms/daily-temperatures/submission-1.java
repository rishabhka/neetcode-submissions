class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] index = new int [temperatures.length] ;
        int n = temperatures.length;
        if(temperatures.length==0)
        return index;
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty())
            stack.push(i);
            else if(temperatures[stack.peek()]<temperatures[i])
            {
                while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i])
                {
                int idx = stack.pop();
                index [idx] = i - idx ; 
                
                }
                
            }
            stack.push(i);

        }
        while(!stack.isEmpty())
        {
            int idx = stack.pop();
            index[idx] = 0;
        }
        return index;
    }
}
