class Solution {
    public int  dfs(String s,int i,int prev,int [][] memo) 
    {
        if(i==s.length()) 
        {
            if(prev==0 )return 1 ;
            else return 0 ;
        }
        else if(memo[i][prev]!=-1) return memo[i][prev] ;
        
        else
        {
            if(Integer.parseInt(s.charAt(i)+"")==0&&prev==0) return 0 ;
            int newnum = prev*10 + Integer.parseInt(s.charAt(i)+"") ;
            if(newnum>26||newnum==0) return 0 ;
            memo[i][prev]=  dfs(s,i+1,newnum,memo)+ dfs(s,i+1,0,memo) ;
            return memo[i][prev] ;
        }
        
    }
    public int numDecodings(String s) {
        int [][] memo = new int[s.length()][27] ;
        for(int i=0;i<s.length();i++)
        Arrays.fill(memo[i],-1) ;
        return dfs(s,0,0,memo) ;
    }
}
