class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[] > stack = new ArrayDeque<>();  // (nums,idx)
        int n = heights.length ; int area= Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(stack.isEmpty()||stack.peek()[0]<=heights[i]) 
            stack.push(new int []{heights[i],i});
            else 
            {
                int [] node = stack.peek();
                while(!stack.isEmpty()&&stack.peek()[0]>heights[i])
                {
                    node = stack.pop();
                    area = Math.max(area,(i-node[1])*node[0]);
                }
                stack.push(new int []{heights[i],node[1]});
            }
        }
        while(!stack.isEmpty())
        {
            int [] node = stack.poll();
            area = Math.max(area,(n-node[1])*node[0]);
        }
        return area ;
    }
}
