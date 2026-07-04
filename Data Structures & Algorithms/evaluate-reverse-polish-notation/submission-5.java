class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++)
        {
            if(tokens[i].equals("*")||tokens[i].equals("+")||tokens[i].equals("-")
            ||tokens[i].equals("/"))
            {
                int result = 1;
                int elem1 = stack.pop();
                int elem2 = stack.pop();
                if(tokens[i].equals("*")) result = elem1*elem2;
                if(tokens[i].equals("+")) result = elem1+elem2;
                if(tokens[i].equals("/")) result = elem2/elem1;
                if(tokens[i].equals("-")) result = elem2-elem1;
                stack.push(result);
            }
            else
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.peek();
    }
}
