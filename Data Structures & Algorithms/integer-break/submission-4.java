class Solution {
    public int maxProduct(int n,int [] dp)
    {
        if(n==0) return 1 ;
        else if(dp[n]!=-1) return dp[n];
        int max = 1 ;
        for(int i=1;i<n;i++)
        {
        max = Math.max(Math.max (max ,maxProduct(n-i,dp)*i),(n-i)*i);
        }
     dp[n]= max ;
     return dp[n];
    }
    public int integerBreak(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp,-1);
        return maxProduct(n,dp);
    }
}