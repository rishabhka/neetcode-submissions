class Solution {
    public class Node
    {
        char c ;
        int idx ;
        Node(char c , int idx)
        {
            this.c = c;
            this.idx = idx ;
        }
    }
    
    public boolean checkValidString(String s) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='*')
            stack2.push(new Node('*',i)) ;
            else if (s.charAt(i)=='(')
            stack1.push(new Node('(',i)) ;
            else 
            {
                if(!stack1.isEmpty())
                stack1.pop();
                else if(!stack2.isEmpty())
                stack2.pop();
                else return false ;

            }
        }
        if(stack1.size()>stack2.size())
        return false ;
        else
        {
            while(!stack1.isEmpty())
            {
            if(stack1.peek().idx>stack2.peek().idx)
            return false;
            else 
            {
                stack1.pop();
                stack2.pop();
            }
            }
        }
        return true ;
    }
}
