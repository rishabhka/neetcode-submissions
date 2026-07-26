class Solution {
    public boolean check(String temp)
    {
        Stack<Character> stack = new Stack<>();
        for(char ch : temp.toCharArray())
        {
            if(ch=='(') stack.push('(') ;
            else 
            {
                if(stack.isEmpty()) return false;
                else if(stack.peek()=='(') stack.pop();
                else return false;
            }
        }
        return stack.isEmpty() ;
    }
    public void dfs(int i ,int j,int n,List<String>  res,String temp)
    {
        if(i>n||j>n) return;
        else if(i==n&&j==n)
        {
        if(check(temp))    
        res.add(temp) ;
        return ;
        }   
        dfs(i+1,j,n,res,temp+"(") ;
        dfs(i,j+1,n,res,temp+")") ;
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
         dfs(0,0,n,res,"") ;
         return res ;
    }
}
