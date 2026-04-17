class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int []> stack = new Stack<>();
        int []  result = new int [temperatures.length];
        stack.push(new int []{temperatures[0],0});

        for(int i=1;i<temperatures.length;i++)
        {
            if(temperatures[i]<stack.peek()[0])
            stack.push(new int []{temperatures[i],i});
            else
            {
                while(!stack.isEmpty()&&temperatures[i]>stack.peek()[0])
                {
                    int [] elem = stack.pop();
                    result[elem[1]] = i-elem[1] ;
                }
                stack.push(new int []{temperatures[i],i});
            }
        }
        return result ;
    }
}