class Solution {
    public int f(int [] dp ,int n)
    {
        if(dp[n]!=-1)
        return dp[n];
        else
        {
            dp[n]=f(dp,n-2) + f(dp,n-1);
            return  dp[n] ;
        }
    }
    public int climbStairs(int n) {
        if(n<0)
        return 0 ;
        if(n==1||n==0)
        return 1;
        int [] dp = new int [n+1] ;
        Arrays.fill(dp,-1);
        dp[0]= 1;
        dp[1]= 1 ;
        f(dp,n);
        return dp[n] ;
    }
}
