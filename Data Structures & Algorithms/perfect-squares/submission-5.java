class Solution {
    public int f(int n,int [] dp)
    {
        if(n==0||n==1)
        return n;
        else if(n<0) return Integer.MAX_VALUE/2;
        else if (dp[n]!=-1) return dp[n];
        else
        {
            int min = Integer.MAX_VALUE/2;
            for(int i=1;i<=n/2;i++)
            {
                min = Math.min(f(n-(int)Math.pow(i,2),dp)+1,min);
            }
            dp[n]= min;
            return dp[n];
        }
    }
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return f(n,dp);
    }
}