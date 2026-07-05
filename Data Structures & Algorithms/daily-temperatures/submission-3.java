class Solution {
    //30,38,30,36,35,40,28]
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int [] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++)
        {
                while(!stack.isEmpty()&&stack.peek()[0]<temperatures[i])
                {
                int [] node = stack.pop();
                res[node[1]]=i-node[1];
                }
                stack.add(new int[]{temperatures[i],i});
        }
        return res;
    }
}
