class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if(n%2!=0)
        return false;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c=='['||c=='{'||c=='(')
            stack.push(c);
            else 
            {   if(stack.isEmpty())
                return false;
                char elem = stack.pop();
                if((elem=='['&&c==']')||(elem=='{'&&c=='}')||(elem=='('&&c==')'))
                continue;
                else 
                return false;
            }
        }
        if(stack.isEmpty())
        return true;
        else return false;
    }
}
