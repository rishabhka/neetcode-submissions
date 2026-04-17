class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = tokens.length;
        for(String token : tokens)
        {
            if(token.equals("+")||token.equals("-")||token.equals("/")||token.equals("*"))
            {
            int top = stack.pop();
            int secondTop = stack.pop(); 
            switch(token)
            {
                case "+": stack.push(secondTop + top) ; break;
                case "-": stack.push(secondTop - top) ; break;
                case "/": stack.push(secondTop / top) ; break;
                case "*": stack.push(secondTop * top) ; break;
            }
            }
            else
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
