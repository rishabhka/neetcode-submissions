class Solution {
    public int maxProduct(int n,int [] dp)
    {
        if(n==1) return  1;
        else if(dp[n]!=-1) return dp[n] ;
        else
        {
            int max_prod = Integer.MIN_VALUE ;
            for(int i=1;i<n;i++)
            {
                int a = i * Math.max(maxProduct(n-i,dp) , n- i ) ;
                max_prod= Math.max(a,max_prod );
            }
            dp[n]= max_prod ;
            return dp[n];
        }

    }
    public int integerBreak(int n) {
        int [] dp = new int[n+1] ;
        Arrays.fill(dp,-1) ;
        return maxProduct(n,dp) ;
    }
}