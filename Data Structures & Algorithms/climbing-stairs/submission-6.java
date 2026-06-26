class Solution {
    public int steps(int n,int [] dp)
    {
        if(n==1||n==2)
        return n;
        else if(dp[n]!=-1)
        return dp[n];
        else 
        {
        dp[n] = steps(n-1,dp) + steps(n-2,dp) ;
        return dp[n];
        }
    }
    public int climbStairs(int n) {
        int [] dp = new int [n+1] ;
        Arrays.fill(dp,-1);
        return steps(n,dp);
    }
}
