class Solution {
    public int DP(int n , int dp[])
    {
        if(n==1||n==0)
        return 1;
        else if(n<0)
        return 0;
        else { 
            if(dp[n-1]==-1)
            dp[n-1] = DP(n-1,dp);
            if(dp[n-2]==-1)
            dp[n-2] = DP(n-2,dp);
            dp[n] = dp[n-1] + dp[n-2] ;
            return dp[n] ;
        }
    }
    public int climbStairs(int n) {
        int [] dp = new int [n+1];
        for(int i=0;i<=n;i++)
        dp[i] = -1;
        return DP(n,dp);
        
    }
}
