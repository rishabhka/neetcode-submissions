class Solution {
    int min = Integer.MAX_VALUE;
    public int f(int n ,int [] dp)
    {
        if(n<=0)  { return 0 ;}
        else if(dp[n]!=-1) return dp[n] ;
        else
        {
            int less = Integer.MAX_VALUE ;
            for (int i = (int)Math.sqrt(n); i >= 1; i--)
            {
                less=Math.min(less,f(n-i*i,dp)+1) ;
            }
            dp[n] = less ;
            return dp[n];
        }
    }
    public int numSquares(int n) {
        int [] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;
        return f(n,dp) ;
        // return min ;
    }
}