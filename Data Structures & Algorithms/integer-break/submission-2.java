class Solution {
    public int f(int n,int [] dp)
    {
        if(n==2||n==3)
        return n;
        else if(dp[n]!=-1)
        return dp[n];
        else if(n==4)
        return f(n-2,dp)*2 ;
        else return f(n-3,dp)*3 ;
    }
    public int integerBreak(int n) {
        if(n==2)
        return 1;
        else if(n==3)
        return 2;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
}