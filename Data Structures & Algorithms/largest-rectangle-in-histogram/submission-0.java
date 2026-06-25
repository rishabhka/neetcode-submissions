class Solution {
    class Pair
    {
        int value ;
        int indx;
        Pair(int value,int indx)
        {
            this.value=value;
            this.indx= indx ;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();
        int area =0;

        for(int i=0;i<heights.length;i++)
        {
            if(stack.isEmpty())
            stack.push(new Pair(heights[i],i));
            else 
            {
            Pair pair = new Pair(heights[i],i); // last popped element to get index from
            while(!stack.isEmpty()&&stack.peek().value>heights[i]) // pop current val
            {
                pair = stack.pop();
                int old_idx= pair.indx;
                int local_area = (i-old_idx)*pair.value;
                if(area<local_area)
                area= local_area;
            }
            //Push that current el
            stack.push(new Pair(heights[i],pair.indx));
            }
        }
        // Now empty stack and calculate remaining area
        while(!stack.isEmpty())
        {
            Pair node = stack.pop();
            int local_area = (heights.length-node.indx)*node.value;
            if(area<local_area)
            area= local_area;
        }

        return area;

    }
}
