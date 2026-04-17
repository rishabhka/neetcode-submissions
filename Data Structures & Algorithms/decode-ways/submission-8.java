class Solution {
    int count =0;
    public int f(String s, int i , int prev,int [][] dp)
    {

    int prev_int = Integer.parseInt(s.substring(prev,i));
        if(prev_int<0||prev_int>26)
        return  0;
        if(prev_int==0)
        return 0 ;
        if(i>=s.length())
        {
        //    count ++;
           return 1 ;
        }
        else if(dp[i][prev]!=-1)
        return dp[i][prev] ;
        
        else
        {
            dp[i][prev] = f(s,i+1,i,dp) + f(s,i+1,prev,dp) ;
            return dp[i][prev] ;
        }

    }
    public int numDecodings(String s) {
        if(s.length()==0
        ||s.charAt(0)=='0')
        return 0 ;
        int [][] dp = new int [s.length()+1][s.length()+1] ;
        for(int i=0;i<s.length();i++)
        Arrays.fill(dp[i],-1);
        return f( s,  1,  0,dp ) ;
    }
}
