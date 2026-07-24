class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int [] res = new int[temperatures.length] ;
        for(int i=0;i<temperatures.length;i++)
        {
            if(stack.isEmpty()||temperatures[stack.peek()]>=temperatures[i])
            stack.push(i);
            else
            {
                while(!stack.isEmpty()&&(temperatures[stack.peek()]<temperatures[i]))
                {
                 int idx = stack.pop();
                 res[idx] = i-idx ;
                }
                stack.push(i) ;
            }
        }
        while(!stack.isEmpty())
        {
            int idx = stack.pop() ;
            res[idx] = 0 ;
        }
        return res ;

    }
}
