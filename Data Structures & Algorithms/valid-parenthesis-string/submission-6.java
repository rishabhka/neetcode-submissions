class Solution {
    class Node
    {
        char ch;
        int idx ;
        Node(char ch,int idx)
        {
            this.ch = ch;
            this.idx = idx ;
        }
    }
    public boolean checkValidString(String s) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch=='*')
            stack2.add(new Node('*',i));
            else if(ch==')')
            {
                if(!stack1.isEmpty())
                stack1.pop();
                else if(!stack2.isEmpty())
                stack2.pop();
                else 
                return false;
            }
            else
            stack1.add(new Node(')',i));
        }
        if( stack1.size()>stack2.size())
        return false;
        else 
        while(!stack2.isEmpty()&&!stack1.isEmpty())
        {
            if(stack1.peek().idx>stack2.peek().idx)
            return false;
            stack1.pop();
            stack2.pop();
            
        }
        return true ;
    }
}
