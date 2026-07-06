class Solution {
    class Node
    {
        int val;
        int idx;
        Node(int val , int idx)
        {
            this.val = val;
            this.idx = idx;
        }
    }
    public int largestRectangleArea(int[] heights) {
        Stack<Node> stack = new Stack<>();
        int max_area = 0;
        int n = heights.length ;
        for(int i=0;i<n;i++)
        {
            if(!stack.isEmpty()&&heights[i]<stack.peek().val)
            {
            Node node = null;
            while(!stack.isEmpty()&&heights[i]<stack.peek().val)
            {
                node = stack.pop();
                int new_area = (i-node.idx)*node.val;
                if(max_area<new_area)
                max_area = new_area ;
            }
            stack.push(new Node(heights[i],node.idx));
            }
            else
            stack.push(new Node(heights[i],i));
        }
        while(!stack.isEmpty())
        {
            Node node = stack.pop();
            int new_area = (n-node.idx)*node.val;
            if(max_area<new_area)
            max_area = new_area ;
        }
        return max_area ;
    }
}
