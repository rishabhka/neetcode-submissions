class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for(int i=0;i<n;i++)
        {
            String token = tokens[i];
            if(token.equals("+")||token.equals("-")||token.equals("/")||token.equals("*"))
            {
                int top = stack.pop();
                int secondTop = stack.pop();
                System.out.println(top + " "+ secondTop);
                if(token.equals("+"))
                {
                 top = top + secondTop;
                }
                if(token.equals("-"))
                {
                 top =  secondTop - top;
                }
                if(token.equals("/"))
                {
                 top = secondTop/top ;
                }
                if(token.equals("*"))
                {
                 top = top * secondTop;
                }
                stack.push(top);
            }
            else
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }
}
